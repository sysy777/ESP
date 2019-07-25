import java.lang.reflect.Array;
import java.util.Scanner;
import DataStructure.FoodBlock;

public class Main {
    public static final int SIZE = 10;
    FoodBlock[] myRef = new FoodBlock[SIZE]; //음식물개수
}

class tools{
    //기존의 음식 삭제 함수
//    void delOld(){
//        for(){
//            System.out.println("String(name of list)");
//        }
//        System.out.println("삭제할 목록 번호를 입력하세요");
//
//        while(true){
//            Scanner in = new Scanner(System.in);
//            if(int i != "yes"){
//                break;
//            }
//        }
//        //들어온 번호 삭제
//        for(){
//            Array.delete(num); //num == 들어온 번호
//        }
//    }

    //음식 목록 출력 함수 **DB연동
//    void printFood(){
//        for(String : DB){
//            System.out.println("String \n");
//        }
//    }

    //새로운 음식 입력
    void inputNew(Scanner in){
        //스캐너로 받아오기
        while(true){
            in.next();
            System.out.println("더 입력하시겠습니까?");
            String i = in.next();
            if(i != "yes"){
                break;
            }
        }
    }
}
