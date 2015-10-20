import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Controller controller=new Controller();
        controller.run(new ConsoleView());

    }
}
