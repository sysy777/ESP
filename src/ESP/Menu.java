package ESP;

import java.io.*;
import java.util.Scanner;

public class Menu{
    public static void menu(File f){
        while(true) {
            System.out.println("======================================================================");
            System.out.println("선택보기 중 하나를 선택해주세요. ");
            System.out.println("1. 음식 목록보기  2. 음식 새로입력  3. 음식 삭제하기  4.종료하기");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            System.out.println("======================================================================");

            if (num == 1) {
                Tools.printFood(f);  //음식보기 함수 호출
                System.out.println("메뉴로 돌아갑니다.");
            } else if (num == 2) {
                Tools.inputNew(f);  //새로운 음식 추가 함수 호출
                System.out.println("메뉴로 돌아갑니다.");
            } else if (num == 3) {
                Tools.delOld(f);  //기존에 있던 음식 삭제하는 함수 호출
                System.out.println("메뉴로 돌아갑니다.");
            } else if (num == 4){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 숫자입니다. 1~4까지의 숫자를 다시 입력해주세요.");
            }
        }
    }






}
