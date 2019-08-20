package ESP;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CarbonTools {
    public static void takeExpired(File f) {
        File ef = new File("expiredFood.txt");
        File cf = new File("carbonConvert.txt");
        String expSet[]=new String[100];

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());

        try {
            BufferedReader fbr = new BufferedReader(new FileReader(f));
            BufferedReader cbr = new BufferedReader(new FileReader(cf));
            BufferedWriter efw = new BufferedWriter(new FileWriter(ef,true));
            PrintWriter epw = new PrintWriter(efw,true);
            String fdline, tuple[];
            double carbon=0; int i=0;

            while ((fdline = fbr.readLine()) != null){
                tuple = fdline.split(" ");
                int today=Integer.parseInt(strToday);
                int fdDate=Integer.parseInt(tuple[1]);
                if(today - fdDate > 0) {
//                    System.out.print("the gap of date: ");
//                    System.out.println(today-fdDate);

                    //탄소량 환산(새 변수)
                    String crbline, ctuple[];

                    //System.out.print("carbonConvert.txt 검사 중...");
                    while((crbline = cbr.readLine()) != null){
                        ctuple = crbline.split(" ");
                        if(compare(tuple[0], ctuple[0])){
                            //System.out.println("yes");
                            carbon = Double.parseDouble((ctuple[2]));
                            //System.out.println("we find the same name...");
                            expSet[i]=tuple[0]; i++;
                            efw.write(tuple[0] + " "+ tuple[1]+ " " + carbon + "\r\n");
                            efw.flush();
                            efw.close();
                            break;
                        }
                    }
                    //아래거 if문 안에 넣음. 후에 메소드로 따로 만들것
                    //expiredFood에 write. <<tuple 이랑 탄소변수

                    //Food에서는 삭제
                    delExpired(f, expSet);

                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        carbonNotice(ef);
    }

    public static void carbonNotice(File ef){
        double carbon=0;
        try {
            BufferedReader ebr = new BufferedReader(new FileReader(ef));
            String ebrline;

            while ((ebrline = ebr.readLine()) != null) {
                String etuple[] = ebrline.split(" ");
                carbon+=Double.parseDouble(etuple[2]);
            }
        }catch(FileNotFoundException e){
        }catch(IOException e){
        }
        System.out.println("현재 낭비한 탄소량은 "+carbon+"g 입니다.");
    }

    public static void delExpired(File f, String[] expSet){
        //File temp = new File("exptemp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            if(br.readLine()==null) {
                return;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br2 = new BufferedReader(new FileReader(f));
            BufferedWriter bw = new BufferedWriter(new FileWriter("carbonToolsTemp.txt"));

            String s = null;

            while((s=br2.readLine()) != null){
                bw.write(s);
                bw.flush();
                bw.newLine();
            }
            br2.close();
            bw.close();

            BufferedReader br3 = new BufferedReader(new FileReader("carbonToolsTemp.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(f));
            try {
                for(String expmember : expSet) {
                    s = br3.readLine();

                    String tuple[] = s.split(" ");
                    if (s != null && !compare(tuple[0], expmember)) {
                        bw2.write(s);
                        bw2.flush();
                        bw2.newLine();
                    }
                }
            } catch(NullPointerException e) {
                //System.out.println("유통기한이 지난 음식이 없습니다");
            }

            br3.close();
            bw2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean compare(String a, String b){
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int i = 0, cnt=0;
        for(char one : bArray){
            if(aArray[i] == bArray[i]) {
                //System.out.println("0");
                cnt++;
            }
            else break;
        }
        if(bArray.length==cnt) return true;
        else return false;
    }
}
