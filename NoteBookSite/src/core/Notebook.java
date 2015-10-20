package core;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by dmitriy on 07.09.15.
 */
public interface Notebook {
    void add(Note b);
    boolean remove(String fio);
    TreeMap<String,TreeSet<Note>> getAll();
    Note getFIO(String fio);
    List<Note> getFirst(String a);
}
