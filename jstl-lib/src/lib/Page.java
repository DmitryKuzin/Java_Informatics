package lib;

import lib.Footer;
import lib.Header;
import lib.LeftMenu;
import lib.MainContent;

/**
 * Created by kuzin on 30.10.2015.
 */
public class Page{
    public Page(String url){
        this.url=url;
    }
    String url;
    Header header=new Header();
    LeftMenu leftMenu=new LeftMenu();
    MainContent mainContent=new MainContent();
    Footer footer=new Footer();

    @Override
    public String toString() {
        return "url"+url+"\n"+header.toString()+leftMenu.toString()+mainContent.toString()+footer.toString();
    }


    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public void setLeftMenu(LeftMenu leftMenu) {
        this.leftMenu = leftMenu;
    }

    public MainContent getMainContent() {
        return mainContent;
    }

    public void setMainContent(MainContent mainContent) {
        this.mainContent = mainContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
