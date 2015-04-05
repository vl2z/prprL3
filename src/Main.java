import java.util.regex.Matcher ; 
import java.util.regex.Pattern ;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("F:/text.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String name;
        String line;
        System.out.println("Print File "+f.getName()+"? y/n");
        name = br.readLine();
        if(name.equals("y"))
            while ((line = fin.readLine()) != null) {
                System.out.println(line);
                System.out.println(checkWithRegExp(line));
            }
    }
    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("bad\\s|worse[\\t\\n\\x0B\\f\\r]|worst\\s|die\\s", Pattern.CASE_INSENSITIVE) ;
        Matcher m = p.matcher(userNameString);
        return m.find() ;
    }
}