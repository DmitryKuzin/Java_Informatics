package lib;

import java.io.Serializable;

/**
 * Created by kuzin on 9/22/2015.
 */
public class City extends iKey implements Comparable{
    public City(){}
    public City(String name){
        setCityName(name);
    }
    private String cityName;
    public void setCityName(String str){
        keyVariable=str;
        cityName=str;
    }
    public String getCityName(){
        return cityName;
    }

}
