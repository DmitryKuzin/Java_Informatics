package core;

import java.io.*;
import java.util.*;

/**
 * Created by kuzin on 29.10.2015.
 */
public class FileNoteBook implements Notebook {
    TreeMap<String,TreeSet<Note>> map=null;
    public FileNoteBook(){
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
    public TreeMap<String,TreeSet<Note>> read(String path){
        TreeMap<String,TreeSet<Note>> source=null;
        try (FileInputStream fin = new FileInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(fin)) {           // Поток для чтения (сериализации) объектов
            source=(TreeMap<String,TreeSet<Note>>)oin.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException f){
            f.printStackTrace();
        }
        return source;
    }

    public void write(String fileName,TreeMap<String,TreeSet<Note>> treeMap){
        try (FileOutputStream fout = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fout)) {        // Поток для записи (сериализации) объектов
            out.writeObject(treeMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
