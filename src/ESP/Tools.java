package ESP;

import ESP.DataStructure.FoodBlock;
import java.io.*;
import java.util.Scanner;

public class Tools {
    static void delOld(File f){
        StringBuilder s1= new StringBuilder();
        StringBuilder s2= new StringBuilder();
        System.out.println("현재 저장된 음식 목록입니다. 삭제를 원하는 음식의 번호를 입력하세요 : ");
        Scanner in = new Scanner(System.in);
        printFood(f);
        int delNum = in.nextInt();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int k=0; k<delNum; k++){
                s1.append(br.readLine());
                s1.append("\r\n");
            }

            String s="";
            s=br.readLine();
            while((s=br.readLine()) != null){
                s2.append(s);
                s2.append("\r\n");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.append(s1);
            bw.append(s2);

            System.out.println("삭제되었습니다.");
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //음식 목록 출력 함수
    static void printFood(File f){
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str="";
            if((str=br.readLine()) == null) {
                System.out.println("등록된 음식이 없습니다.");
//                System.out.println("등록된 음식이 없습니다. 음식을 등록하려면 1을, 아니라면 1을 제외한 아무숫자를 입력하세요. : ");
//                Scanner in = new Scanner(System.in);
//                int ans = in.nextInt();
//                if (ans == 1) inputNew(f);

            }
            else {
                int k = 1;
                while(br.readLine() != null){
                    //3번째 줄부터 출력됨.
                    System.out.println(k + " " + br.readLine());
                    k++;
                }
            }

            br.close();
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
