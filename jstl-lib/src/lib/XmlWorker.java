package lib;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lib.Page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by kuzin on 30.10.2015.
 */
public class XmlWorker {

    public Page read(String path,String pageUrl){
        XStream xs = new XStream(new DomDriver());
        Page page = new Page(pageUrl);

        try {
            FileInputStream fis = new FileInputStream(path);
            xs.fromXML(fis, page);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return page;
    }
    public void write(Page page,String path){
        //Объект-сериализатор
        XStream xs = new XStream(new DomDriver());

        //Write to a file in the file system
        try {
            FileOutputStream fs = new FileOutputStream(path);
            xs.toXML(page, fs);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
