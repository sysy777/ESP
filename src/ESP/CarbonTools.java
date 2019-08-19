package ESP;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CarbonTools {
    public static void takeExpired(File f) {
        File ef = new File("expiredFood.txt");
        File cf = new File("carbonConvert.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());

        try {
            BufferedReader fbr = new BufferedReader(new FileReader(f));
            BufferedReader cbr = new BufferedReader(new FileReader(cf));
            BufferedWriter efw = new BufferedWriter(new FileWriter(ef,true));
            PrintWriter epw = new PrintWriter(efw,true);
            String fdline,  tuple[];
            int carbon=0;

            while ((fdline = fbr.readLine()) != null){
                tuple = fdline.split(" ");
                int today=Integer.parseInt(strToday);
                int fdDate=Integer.parseInt(tuple[1]);
                if(today - fdDate > 0) {
                    //탄소량 환산(새 변수)
                    String crbline, ctuple[];
                    while((crbline = cbr.readLine()) != null){
                        ctuple = crbline.split(" ");
                        if(tuple[0].compareTo(ctuple[0])==0){
                            carbon = Integer.parseInt((ctuple[2]));
                            break;
                        }
                    }
                    //expiredFood에 write tuple 이랑 탄소변수
                    efw.write(tuple[0] + " "+ tuple[1]+ " " + carbon + "\r\n");
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
