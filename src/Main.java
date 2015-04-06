import java.util.regex.Matcher ; 
import java.util.regex.Pattern ;

import java.io.*;
//http://www.enchantedlearning.com/wordlist/negativewords.shtml

public class Main{
    static  Pattern[] pAr = new Pattern[] {
            Pattern.compile("bad\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sdie[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("worse\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("worst\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\ssuffer[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("mad\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("crazy\\s", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\snightmare[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sdeath[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sfear[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sfuck[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\sshit[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\skill[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\shurt[a-z]*", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\swreck[a-z]*", Pattern.CASE_INSENSITIVE),
    };
    static int full=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("F:/text.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String name;
        String fl;
        String line;
        System.out.println("Search in File "+f.getName()+"? y/n");
        name = br.readLine();
        if(name.equals("y")) {
            System.out.println("Search with full output? y/n");
            fl = br.readLine();
            if (fl.equals("y"))
                while ((line = fin.readLine()) != null) {
                    System.out.println(line);
                    checkWithRegExp(line);
                }
            else
                while ((line = fin.readLine()) != null) {
                    checkWithRegExp(line);
                }
                System.out.println("All negative hits (\"text mood\") = -"+full);
        }
    }
    public static void checkWithRegExp(String userNameString){
        Matcher m;
        for(Pattern p:pAr){
            m = p.matcher(userNameString);
            if (m.find()) {
                full++;
                System.out.println("\t\t Hit with: " +p+" pattern");
            }
        }
    }

}