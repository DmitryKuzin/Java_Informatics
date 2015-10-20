import java.util.Date;

/**
 * Created by kuzin on 9/19/2015.
 */
public class Node {
    public Node(String FIO,String birth){
        this.birth=birth;
        this.FIO=FIO;
    }
    String FIO;
    String birth;
    Node leftSon;
    Node rightSon;
}
