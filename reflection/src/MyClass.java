import java.io.Serializable;
import java.util.Date;

/**
 * Created by kuzin on 03.12.2015.
 */
@JSONable
public class MyClass extends Thread implements Serializable,Cloneable{
    @JSONignore
    private String p1="ghjv";
    public int p2=0;
    protected double p3=0.2;
    @JSONname("myname")
    boolean p4=false;
    @DataFormate("yyyy.MM.dd")
    Date d=new Date();

    String[] arr={"abc","xyz"};
    MyClass(){}

    MyClass(String p1,boolean p4){
        this.p1=p1;
        this.p4=p4;
    }

    public void showAll(){}
    private int incP2(int d){return p2+d;}

}
