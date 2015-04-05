import java.util.regex.Matcher ; 
import java.util.regex.Pattern ;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
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
                System.out.println("All negative hits (\"text mood\") = -"+quantity);
        }
    }
    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("bad\\s|worse[\\t\\n\\x0B\\f\\r]|worst\\s|die\\s", Pattern.CASE_INSENSITIVE) ;
        Matcher m = p.matcher(userNameString);
        return m.find() ;
    }

}