package view;
import java.util.Scanner;

public class ConsoleView {
    Scanner sc=new Scanner(System.in);
    public void showArray(int[] arr){
        System.out.println("");
        if(arr.length>10){
            System.out.println("Because of your array have more than 10 items we show you top 10");
            System.out.println("If you'd like to view more items just write -giveMeMore");
            for (int i = 0; i < 10; i++) {
                System.out.print(arr[i] + "|");
            }

        }else {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "|");
            }

        }
    }
    public void showFullArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "|");
        }
        System.out.println("");
    }
    public void showArray(int[] arr,String sortAlgorithm,double time){
        System.out.println("");
        System.out.print(sortAlgorithm+"    ");
       showArray(arr);
        System.out.println("    Sorted for :"+time+"ms");
    }
    public int[] askForArray(){

        System.out.println("Insert array members");
        int[] a=new int[10];
        int lastindex=0;
        String ins="";
        System.out.println("For stop inserting write -stop");
        while(true){
            ins=sc.next();
            if(ins.equals("-stop")) break;
            if(lastindex<a.length){
                try {
                    a[lastindex++] = new Integer(ins);
                }catch(Exception e){
                    System.out.println("Can you slow down? You make mistakes!");
                }
            }else{
                int[] arr=new int[a.length*2];
                System.arraycopy(a,0,arr,0,lastindex);
                a=arr;
                try {
                    a[lastindex++] = new Integer(ins);
                }catch(Exception e){
                    System.out.println("Can you slow down? You make mistakes!");
                }
            }
        }
        int[] b=new int[lastindex];
        System.arraycopy(a,0,b,0,lastindex);
        return b;
    }

    public void showLegend(){
        System.out.println("Write commands from list below");
        System.out.println("-legend");
        System.out.println("-add");
        System.out.println("-generate");
        System.out.println("-show");
        System.out.println("-save");
        System.out.println("-sort");
        System.out.println("-exit");
    }
    public void showMessage(String s){
        System.out.println(s);
    }
    public String askWhatToDO(){
        System.out.println("->");
        return sc.next();
    }

}
