package lib;

/**
 * Created by kuzin on 10/22/2015.
 */
public class Main {
    public static void main(String[] args) {
        String a="123456,4;";
        System.out.println(a.substring(0,a.indexOf(",")));
        System.out.println(a.substring(a.indexOf(",")+1,a.indexOf(";")));
    }
}
