package ESP;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CarbonTools {
    public static void takeExpired() {
        File f = new File("expiredFood.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            FileWriter fw = new FileWriter(f);
            String fdline,  carbon, tuple[];

            while ((fdline = br.readLine()) != null){
                tuple = fdline.split(" ");
                int today=Integer.parseInt(strToday);
                int fdDate=Integer.parseInt(tuple[1]);
                if(today - fdDate > 0) {
                    //탄소량 환산(새 변수)
                    //expiredFood에 write tuple 이랑 탄소변수
                    //Food에서는 삭제
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
