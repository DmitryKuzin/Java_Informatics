import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kuzin on 9/13/2015.
 */
public class Main {
    public static void main(String[] args) {
        String str4="511-22-33";
        String str5="+7(843)654-89-65";
        String str6="?????? ???? ????????";
        String str7="example@me.com";
        String str8="123:abc\n345:dsf";
        String str="100;10;name;zero;";
        Pattern p1=Pattern.compile("NAM1E");
        Pattern p2=Pattern.compile(".*name*.");
        Pattern p3a=Pattern.compile("a+b*");
        Pattern p3b=Pattern.compile("\\\\*\\**");
        Pattern p3c=Pattern.compile("(param){3}");
        Pattern p3d=Pattern.compile("(.|\n){5}");
        Pattern p4=Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Pattern p5=Pattern.compile("\\+\\d\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Pattern p6=Pattern.compile("[A-Z?-?][a-z?-?]*?\\s[A-Z?-?][a-z?-?]*?\\s[A-Z?-?][a-z?-?]*?");
        Pattern p7=Pattern.compile("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}");
        String[] p8=str8.split("\\n");
        Matcher email=p7.matcher(str7);
        System.out.println(email.matches());
        Map<Integer,String> map=new TreeMap();
//        for(String s : p8)
//        {
//            map.put(new Integer(s.substring(0, 3)), s.substring(4));
//        }
        String[] p9=str.split("\\\\<a href=");
        String[] p9a=str.split("\\\\<a href=?");
//        for(String s1:p9){
//            System.out.println(s1.substring(9,s1.indexOf("/>")-1));
//        }
//        String p10=str.replaceAll("\".*\"","\"123\"");
//        String p12=str.replaceAll("<a href=", "<a class=");
//        String p14=str.replace("\\.*/\\>\\</a\\>", " ");
        String p16=str.replaceFirst(";.+?;",";");
//        System.out.println(p10);
//        System.out.println(p12);
//        System.out.println(p14);
        System.out.println(p16);
        Pattern p=Pattern.compile("");
//        Pattern p8=Pattern.compile("(.*?):(.*)(\n|$)");

        Matcher m=p6.matcher(str);

       // n.replaceAll("$1");
       // map.put(m.group(1),m.group(2));
        System.out.println(m.matches());
    }
}
