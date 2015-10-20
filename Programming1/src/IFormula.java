/**
 * @author Gataullin Kamil
 *         16.01.2015 21:32
 */
public interface IFormula {

    int sum(int a, int b);

    default double sqrt(double a) {
        return Math.sqrt(a);
    }
    default boolean chetnost(int a){
        return a%2==0?true:false;
    }
}
