import org.omg.CORBA.*;

import java.lang.Object;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dmitriy on 10.09.15.
 */
public class Main {
    public static void main(String[] args) {
        String str="<a> Hello</a>";
        String str1="123:abc\n345:dsf";
        Pattern p=Pattern.compile("NAM1E");
        Pattern p1=Pattern.compile(".*name*.");
        Pattern p2=Pattern.compile("a+b*");
        Pattern p3=Pattern.compile("\\\\*\\**");
        Pattern p4=Pattern.compile("(param){3}");
        Pattern p5=Pattern.compile("(.|\n){5}");
        Pattern p6=Pattern.compile("");
        Pattern p7=Pattern.compile("\\+\\d\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Map<Object,Object> map=new TreeMap();
        Pattern p8=Pattern.compile("(.*?):(.*)(\n|$)");
        Pattern p9=Pattern.compile("<a>(\\w*)<\a>");
        Matcher m=p7.matcher(str);
        Matcher n=p9.matcher(str);
        n.replaceAll("$1");
        map.put(m.group(1),m.group(2));
        System.out.println(m.matches());
    }
}
