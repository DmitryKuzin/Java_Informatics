package model.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileEditor{
    public static int[] read(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        try {
            File file=new File(fileName);

            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {

                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("|");
                }
            } finally {

                in.close();
            }
        } catch(IOException e) {
            throw new FileNotFoundException();
        }
        String s=sb.toString();
        List<Integer> list=new ArrayList<>();
        while(s.length()>0){
            list.add(new Integer(s.substring(0,s.indexOf("|"))));
            s=s.substring(s.indexOf("|")+1);
        }

        int[] arr=new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }

        return arr;
    }
    public static void write(String fileName, int[] array) {
        File file = new File(fileName);

        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                for (int i = 0; i < array.length; i++) {
                    out.print(""+array[i]+"\n");
                }
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}