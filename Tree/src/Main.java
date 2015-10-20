
public class Main {
    public static void main(String[] args) {
        Tree tree=new Tree();
        try {
            tree.add("Ivan Anreevich Krylov", "22.07.1890");
            tree.add("Pert Sergeevich Xuiyevsky", "11.10.1888");
            tree.add("Alexandr Sergeevich Pushkin", "15.01.1789");
            tree.add("Alexandr Sergeevich Pushkin", "15.01.1789");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Pushkin's birthday -" + " " + tree.get("Sergeevich Pushkin"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
