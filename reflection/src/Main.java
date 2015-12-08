
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kuzin on 03.12.2015.
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyClass mc=new MyClass();
        System.out.println(toJSON(mc.getClass(),mc));

    }

    public static String toJSON(Class c,Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String tmp="";

        List<Field> ignoredFields=new ArrayList<>();
        Map<String,String> renameMap=new TreeMap<>();
        Map<String,String> dateMap=new TreeMap<>();
        if(!c.isAnnotationPresent(JSONable.class)){
            return "";

        }
        Field[] fields = c.getDeclaredFields();

        for(Field fi: fields){
            if(fi.isAnnotationPresent(JSONignore.class)) {
                ignoredFields.add(fi);
            }

            for(Annotation annotation : fi.getDeclaredAnnotations()){
                if(annotation.annotationType().getName().equals("JSONname")){
                    Class<?> a=annotation.getClass();
                    renameMap.put(fi.getName(),(String) a.getMethod("value").invoke(annotation));
                }
                if(annotation.annotationType().getName().equals("DataFormate")){
                    Class<?> b=annotation.getClass();
                    dateMap.put(fi.getName(),(String) b.getMethod("value").invoke(annotation));
                }
            }
        }

        tmp+="{\n";
        for(Field field:fields){
            if(ignoredFields.contains(field)){
                continue;
            }
            if(renameMap.keySet().contains(field.getName())){

                tmp+="\"" + renameMap.get(field.getName()) + "\":";
            }else {

                tmp+="\"" + field.getName() + "\":";
            }
                field.setAccessible(true);
                try {
                    if (field.get(obj).getClass().getTypeName().equals("java.lang.String")) {

                        tmp+="\"" + field.get(obj) + "\",\n";
                    } else if(dateMap.keySet().contains(field.getName())){
                        SimpleDateFormat dt=new SimpleDateFormat(dateMap.get(field.getName()));
                        tmp+="\""+dt.format(field.get(obj))+"\"\n";
                    }else {
                        Class<?> d = field.getType();
                        if (d.isArray()) {
                            tmp+="[\n";
                            tmp+="{";
                            int length = Array.getLength(field.get(obj));
                            for (int i = 0; i < length; i++) {
                                Object arrayElement = Array.get(field.get(obj), i);
                                tmp+="\"" + arrayElement + "\"";
                                if (i < length - 1) {
                                    tmp+=",";
                                }
                            }
                            tmp+="}\n";
                            tmp+="]\n";
                        } else {
                            tmp+="" + field.get(obj) + ", \n";
                        }
                    }
                } catch (NullPointerException ex) {
                    System.out.println("unexeptable format");
                    tmp+="unexeptable format";
                }

        }
        tmp+="}\n";
        return tmp;
    }

}
