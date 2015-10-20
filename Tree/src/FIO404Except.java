/**
 * Created by kuzin on 9/19/2015.
 */
public class FIO404Except extends Exception {
    @Override
    public String getMessage() {
        return "FIO not found";
    }
}
