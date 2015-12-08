package lib;

/**
 * Created by kuzin on 30.10.2015.
 */
public class MainContent {
    public MainContent(){}
    public MainContent(String article){
        setArticle(article);
    }
    String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "lib.MainContent:"+article+"\n";
    }
}
