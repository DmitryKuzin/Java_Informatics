package lib;

import java.util.*;

/**
 * Created by kuzin on 30.10.2015.
 */
public class Header {
    public Header(){}
    public Header(List<String> src){
        setLi(src);
    }

    List<String> li=new ArrayList<>();

    public List<String> getLi() {
        return li;
    }

    public void setLi(List<String> li) {
        this.li = li;
    }

    @Override
    public String toString() {
        String template="header:";
        for (String u : li) {
                template += u + "\n";
        }
        return template;
    }
}
