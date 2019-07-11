import java.util.Scanner;

public class Menu{
    static void menu() {
        //사용자가 할 수 있는 행동 제시
        System.out.print("선택보기 중 하나를 선택해주세요. ");
        System.out.print("1. 음식 목록보기  2. 음식 새로입력  3. 음식 삭제하기\n");
        Scanner in =new Scanner(System.in);
        int num = in.nextInt();

        if(num==1){
//            printFood();  //음식보기 함수 호출
        }else if(num==2){
//            inputNew();  //새로운 음식 추가 함수 호출
        }else if(num==3){
//            delOld();  //기존에 있던 음식 삭제하는 함수 호출
        }else{
            System.out.println("잘못된 숫자입니다. !~3까지의 숫자를 다시 입력해주세요.");
            menu(); // 1,2,3번 중 해당하는 숫자가 없을 시에 1번 항목으로 출력
        }
    }

    public static void main(String[] args) {
        menu();
    }
}