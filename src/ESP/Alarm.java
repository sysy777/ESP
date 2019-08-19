package ESP;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Alarm {
    public static void alarm(File f){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line, tuple[];

            while ((line = br.readLine()) != null){
                tuple = line.split(" ");
                int today = Integer.parseInt(strToday);
                int fooday= Integer.parseInt(tuple[1]);
                if(today == fooday){
                    System.out.println(tuple[0]+"의 유통기한이 "+strToday+"까지 입니다.");
                }
                else if((today-fooday)>0) {
                    int gapofDate[] = new int[3];
                    for(int i=0; i<3; i++){
                        gapofDate[i]=today%100 - fooday%100;
                        today/=100; fooday/=100;
                    }
                    int total = gapofDate[0] + gapofDate[1]*30 + gapofDate[2]*365;

                    System.out.println(tuple[0]+"의 유통기한이 약"+total+"일 만큼 지났습니다.");
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
