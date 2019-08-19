package ESP;

import ESP.DataStructure.FoodBlock;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Tools {
    static void delOld(File f) {
        System.out.println("현재 저장된 음식 목록입니다. ");
        Scanner in = new Scanner(System.in);
        printFood(f);
        File temp = new File("temp.txt");
        int delNum=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            if(br.readLine()==null) {
                return;
            } else{
                System.out.println("삭제를 원하는 음식의 번호를 입력하세요 : ");
                delNum = in.nextInt();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br2 = new BufferedReader(new FileReader(f));
            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));

            String s = null;

            while((s=br2.readLine()) != null){
                bw.write(s);
                bw.flush();
                bw.newLine();
            }
            br2.close();
            bw.close();

            BufferedReader br3 = new BufferedReader(new FileReader("temp.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(f));

            for(int k=0; k<delNum-1; k++){
                s=br3.readLine();
                if(s != null) {
                    bw2.write(s);
                    bw2.flush();
                    bw2.newLine();
                }
            }

            s=br3.readLine();
            while((s=br3.readLine()) != null){
                bw2.write(s);
                bw2.flush();
                bw2.newLine();
            }

            br3.close();

            System.out.println("삭제되었습니다.");
            bw2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //음식 목록 출력 함수
    static void printFood(File f){
        try{
            String s = "";
            BufferedReader br = new BufferedReader(new FileReader(f));
            int k = 1;
            while(true){
                s=br.readLine();
                if(s == null){
                    System.out.print("더이상 등록된 음식이 없습니다. ");
                    break;
                }
                else {
                    System.out.println(k + " " + s);
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
        Scanner in = new Scanner(System.in);

        System.out.print("저장하실 음식의 개수를 입력하세요 : ");
        int n = in.nextInt();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            for(int i=0; i<n; i++) {
                System.out.print("음식명을 입력하세요 : ");
                String a = in.next();
                System.out.print("유통기한을 입력하세요(YYMMDD) : ");
                int b = in.nextInt();
                while(b < 100000 || b >= 1000000){
                    System.out.print("잘못된 숫자입니다. 다시 입력하세요 : ");
                    b = in.nextInt();
                }
                bw.write(a + " " + b + "\r\n");
            }
            bw.flush();
            bw.close();
            System.out.println("저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
