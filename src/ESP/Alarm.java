package ESP;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Alarm {
    public void alarm(File f){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String tuple, date[];

            while ((tuple = br.readLine()) != null){
                date = tuple.split(" ");
                if(date[0].compareTo(strToday)==0){
                    System.out.println(date[1]+"의 유통기한이 "+strToday+"까지 입니다.");
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
