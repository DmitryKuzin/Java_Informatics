package core;

/**
 * Created by dmitriy on 09.09.15.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleView cv=new ConsoleView();
        while(!cv.getIsExit()){
            cv.userExperience();
        }
    }
}
