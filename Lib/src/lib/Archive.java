package lib;

import lib.Library;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by kuzin on 9/22/2015.
 */
public class Archive {
    TreeMap<City,TreeMap<Author,TreeSet<Book>>> archive=new TreeMap<>();
    public void setLib(City c, Library l){
        archive.put(c,l.getAll());
    }
}
