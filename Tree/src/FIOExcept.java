/**
 * Created by kuzin on 9/19/2015.
 */
public class FIOExcept extends Exception{
    @Override
    public String getMessage() {
        return "Such FIO already exists";
    }
}
