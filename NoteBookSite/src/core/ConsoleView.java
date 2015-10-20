package core;
import java.util.*;

public class ConsoleView {
    ConsoleNoteBook cnb=new ConsoleNoteBook();
    Scanner sc=new Scanner(System.in);
    private boolean isExit=false;
    public boolean getIsExit(){
        return isExit;
    }
    public void userExperience(){

        System.out.println("Введите -a для добавления новой записи");
        System.out.println("Введите -х для показа записи по ФИО");
        System.out.println("Введите -с для показа всех записей");
        System.out.println("Введите -о для показа записи по букве");
        System.out.println("Введите -е для выхода");
        String str=sc.next();
        switch (str){
//            case "-a" : add();
//                break;
            case "-x" :getFIO();
                break;
            case "-c" : getAll();
                break;
            case "-o" : getFirst();
                break;
            case "-e" : isExit=true;
                break;
            default:
                System.out.println("Не понятно! Повторите ввод!");
                break;
        }
    }
    //добавление
//    public void add(){
//        String name,lastName,fatherName,phone,birth;
//        System.out.println("Добавление");
//        System.out.println("ФИО->");
//        System.out.println("Фамилия->");
//        lastName=sc.next();
//        System.out.println("Имя->");
//        name=sc.next();
//        System.out.println("Отчетво->");
//        fatherName=sc.next();
//        System.out.println("Телефон->");
//        phone=sc.next();
//        System.out.println("День рождения->");
//        birth=sc.next();
//        cnb.add(new Note(lastName+" "+name+" "+fatherName,birth,phone));
//    }
    //получить все записи
    public void getAll(){
        TreeMap<String,TreeSet<Note>> map=cnb.getAll();
        Set<String> set=map.keySet();
        for(String s: set){
            System.out.println(s);
            showTreeSet(map.get(s));
        }
    }

    private void showTreeSet(TreeSet<Note> set){
       for(Note n: set){
           System.out.println("     *");
           System.out.println("       "+n.FIO);
           System.out.println("       Телефон:"+n.phone);
           System.out.println("       День рождения:"+n.birthday);
           System.out.println("     *");
       }
    }
    private void showTreeSet(List<Note> set){
        for(Note n: set){
            System.out.println("     *");
            System.out.println("       "+n.FIO);
            System.out.println("       Телефон:"+n.phone);
            System.out.println("       День рождения:"+n.birthday);
            System.out.println("     *");
        }
    }
    private void showNote(Note n){
        System.out.println("*");
        System.out.println("  "+n.FIO);
        System.out.println("  Телефон:"+n.phone);
        System.out.println("  День рождения:"+n.birthday);
        System.out.println("*");
    }
    //получить по фамилии
    public void getFIO(){
        System.out.println("Поиск по ФИО");
        System.out.println("Введите ФИО->");
        System.out.println("Фамилия->");
        String lastName=sc.next();
        System.out.println("Имя->");
        String name=sc.next();
        System.out.println("Отчетво->");
        String fatherName=sc.next();
        showNote(cnb.getFIO(lastName+" "+name+" "+fatherName));
    }
    //получить по букве
    public void getFirst(){
        System.out.print("Введите букву->");
        showTreeSet(cnb.getFirst(sc.next()));
    }
}
