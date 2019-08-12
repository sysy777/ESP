package ESP;

import ESP.DataStructure.FoodBlock;
import java.io.*;
import java.util.Scanner;

public class Tools {
    //기존의 음식 삭제 함수(덮어쓰기로 해야할듯)
//    static void delOld(File f){

//    }

    //음식 목록 출력 함수
    static void printFood(File f){
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            int k = 1;
            while((str = br.readLine()) != null){
                //이러면 목록에 아무것도 없을 때 번호 1만 출력됨...
                System.out.println(k + " " + str);
                k++;
            }
            if(str == null) {
                System.out.println("등록된 음식이 없습니다. 음식을 등록하려면 1을, 아니라면 1을 제외한 아무숫자를 입력하세요. : ");
                Scanner in = new Scanner(System.in);
                int ans = in.nextInt();
                if (ans == 1) inputNew(f);
            }

            br.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //새로운 음식 입력
    static void inputNew(File f){
        //스캐너로 받아오기
        Scanner in = new Scanner(System.in);

        System.out.print("저장하실 음식의 개수를 입력하세요 : ");
        int n = in.nextInt();
        try {
            FileWriter fw = new FileWriter(f, true);
            for(int i=0; i<n; i++) {
                System.out.print("음식명을 입력하세요 : ");
                String a = in.next();
                System.out.print("유통기한을 입력하세요(YYMMDD) : ");
                int b = in.nextInt();
                FoodBlock fb = new FoodBlock(a,b);
                fw.write(a + " " + b + "\r\n");
            }
            System.out.println("저장되었습니다.");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
