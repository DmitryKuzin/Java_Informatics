package lib;

import lib.Footer;
import lib.Header;
import lib.LeftMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by kuzin on 31.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        XmlWorker xmlWorker=new XmlWorker();
        Page p=new Page("/main");
        p.setFooter(new Footer("ITIS Kazan 2015"));

        List<String> li=new ArrayList<>();
        li.add("Главная");
        li.add("Статьи");
        li.add("О нас");
        li.add("Контакт");
        li.add("Помощь");
        p.setHeader(new Header(li));

        p.setLeftMenu(new LeftMenu());

        p.setMainContent(new MainContent("I'm article"));
        xmlWorker.write(p,"conf.txt");
        System.out.println("All done,boss!");
    }
}
