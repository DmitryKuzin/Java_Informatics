package core;

import java.awt.print.Book;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by dmitriy on 09.09.15.
 */
public class Main {
    public static void main(String[] args) {
        FileNoteBook fnb=new FileNoteBook();
        TreeMap<String,TreeSet<Note>> map=new TreeMap<>();
        TreeSet<Note> set=new TreeSet<>();
        set.add(new Note("Arbuzov Arbuz Arbuzovuch","bitrh","phone","email","address"));
        set.add(new Note("Arbuzov Armen Arbuzovuch","bitrh","phone","email","address"));
        set.add(new Note("Arbuzov Artem Arbuzovuch","bitrh","phone","email","address"));
        set.add(new Note("Arbuzov Evgen Arbuzovuch","bitrh","phone","email","address"));
        map.put("A",set);
        fnb.write("map.dat",map);
        TreeMap<String,TreeSet<Note>> newMap=fnb.read("./map.dat");
        newMap.put("sf",set);
    }
}
