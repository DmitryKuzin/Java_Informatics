package lib;

/**
 * Created by kuzin on 30.10.2015.
 */
public class Footer {
    public Footer(){}
    public Footer(String footer){
        setFooter(footer);
    }
    String footer;

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "footer:"+footer+"\n";
    }
}
