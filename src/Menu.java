import java.io.File;
import java.util.Scanner;

public class Menu{//메뉴파일
    static void menu(File f) {
        //사용자가 할 수 있는 행동 제시
        while(true) {
            System.out.println("선택보기 중 하나를 선택해주세요. ");
            System.out.println("1. 음식 목록보기  2. 음식 새로입력  3. 음식 삭제하기  4.종료하기");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();

            if (num == 1) {
                tools.printFood(f);  //음식보기 함수 호출
            } else if (num == 2) {
                tools.inputNew(f);  //새로운 음식 추가 함수 호출
            } else if (num == 3) {
                //            tools.delOld(f);  //기존에 있던 음식 삭제하는 함수 호출
            } else if (num == 4){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 숫자입니다. 1~4까지의 숫자를 다시 입력해주세요.");
                // 1,2,3번 중 해당하는 숫자가 없을 시에 1번 항목으로 출력
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("food.txt");
        menu(f);
    }
}
