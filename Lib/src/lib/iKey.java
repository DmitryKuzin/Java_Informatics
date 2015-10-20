package lib;

import java.io.Serializable;

/**
 * Created by kuzin on 9/22/2015.
 */
public class iKey implements Comparable,Serializable {
    String keyVariable;
    @Override
    public int compareTo(Object o) {
        if(o.hashCode()==hashCode()){ return 0;}
        else{
            if(hashCode()>o.hashCode()){
                return -1;
            }else{
                return 1;
            }
        }

    }

    @Override
    public int hashCode() {
        return keyVariable.hashCode();
    }
}
