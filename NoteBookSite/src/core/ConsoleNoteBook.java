package core;
import core.Note;

import java.util.*;

/**
 * Created by dmitriy on 07.09.15.
 */
public class ConsoleNoteBook implements Notebook {
    TreeMap<String,TreeSet<Note>> map=null;
    public ConsoleNoteBook(){
        map=new TreeMap<>();
    }
    @Override
    public void add(Note b) {
        if(!map.containsKey(b.FIO.substring(0,1))){
            TreeSet<Note> ts=new TreeSet<>();
            ts.add(b);
            map.put(b.FIO.substring(0,1),ts);
        }else{
            TreeSet ts=map.get(b.FIO.substring(0,1));
            ts.add(b);
            map.replace(b.FIO.substring(0, 1),ts);
        }
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
    public Set<String> getKeys(){return map.keySet();}
    @Override
    public boolean remove(String fio) {
        TreeSet<Note> ts=map.get(fio.substring(0,1));
        boolean isFounded=false;
        for(Note n : ts){
            if(n.FIO.equals(fio)){
                ts.remove(n);
                isFounded=true;
            }
        }
        return isFounded;
    }

    @Override
    public TreeMap<String,TreeSet<Note>> getAll() {
        return map;
    }

    @Override
    public Note getFIO(String fio) {
        TreeSet<Note> ts=map.get(fio.substring(0,1));
        Note m=null;
        for(Note n : ts){
            if(n.FIO.equals(fio)){
                m=n;
            }
        }
        return m;
    }

    @Override
    public List<Note> getFirst(String a) {
        List<Note> l=new ArrayList<>(map.get(a));
        return l;
    }
    public Note getExistNote(List<String> names){
        Note n=null;
        for (String s: names){
            if(s.substring(0,1).equals("*")) {
                s=s.substring(1);
                n=getFIO(s);
            }
        }
        return n;
    }
}
