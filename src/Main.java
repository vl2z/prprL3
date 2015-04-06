import java.util.regex.Matcher ; 
import java.util.regex.Pattern ;

import java.io.*;

public class Main{
    static  Pattern[] pAr = new Pattern[] {
           // Pattern.compile("bad\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sdie[a-z]*"),
            Pattern.compile("worse\\s")
    };
    static int full;
    public static void main(String[] args) throws IOException{

        //Pattern p = Pattern.compile("bad\\s|worse\\s|worst\\s|\\sdie[a-z]*|\\ssuffer[a-z]*|mad\\s|crazy\\s|\\snightmare[a-z]*|\\sdeath[a-z]*|\\sfear[a-z]*", Pattern.CASE_INSENSITIVE) ;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("F:/text.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String name;
        String fl;
        String line;
        int quantity=0;
        System.out.println("Search in File "+f.getName()+"? y/n");
        name = br.readLine();
        if(name.equals("y")) {
            System.out.println("Search with full output? y/n");
            fl = br.readLine();
            if (fl.equals("y"))
                while ((line = fin.readLine()) != null) {
                    System.out.println(line);
                    if (checkWithRegExp(line)) {
                        System.out.println("\t\t TRUE");
                        quantity++;
                    }
                }
            else
                while ((line = fin.readLine()) != null) {
                    if (checkWithRegExp(line)) {
                        quantity++;
                    }
                }
                System.out.println("All negative hits (\"text mood\") = -"+full);
        }
    }
    /*public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("bad\\s|worse\\s|worst\\s|\\sdie[a-z]*|\\ssuffer[a-z]*|mad\\s|crazy\\s|\\snightmare[a-z]*|\\sdeath[a-z]*|\\sfear[a-z]*", Pattern.CASE_INSENSITIVE) ;
        Matcher m = p.matcher(userNameString);
        return m.find() ;
    }*/
    public static boolean checkWithRegExp(String userNameString){
        Matcher m=null;
        boolean b=false;
        for (int j=0; j<pAr.length; j++) {
            m = pAr[j].matcher(userNameString);
            if (m.find()) {
                full++;
                b=true;
            }
            else
                b=false;
        }
        return b;
    }

}