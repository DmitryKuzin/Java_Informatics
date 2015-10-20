/**
 * @author Gataullin Kamil
 *         08.02.2015 14:17
 */
@FunctionalInterface // не обязательно, но желательно
public interface Converter<F, T> {

    T convert(F from);

    default Boolean onlyString(F p1, T p2) {
        return p1 instanceof String && p2 instanceof String;
    }
}