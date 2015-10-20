import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Gataullin Kamil
 *         16.01.2015 21:24
 */
public class NewInJava8 {

    public static void main(String[] args) {

//        методы интерфейсов по умолчанию (default interface methods)
//        defaultInterfaceMethods();

//        лямбда-выражения (lambda expressions)
//        lambdaExpressions();

//        функциональные интерфейсы (functional interface)
//        functionalInterface();

//        область действия лямбда
//        lambdaError();

//        Встроенные функциональные интерфейсы (Google Guava)
//        predicate();
//        function();
//        supplier();
//        consumer();
//        comparator();

//        потоки
//        stream();

//        Ассоциативные массивы
 //       maps();

  //      parallelStream();

//        API для работы с датами
//        APIDate.main(null);

//        повторяемые аннотации (repeatable annotations) : для самостоятельного изучения!
//         Arrays.parallelSort()
//        и другое...
    }

    public static void defaultInterfaceMethods() {
        IFormula formula = new Formula();
        System.out.println("formula.sum(100, 15) = " + formula.sum(100, 15));
        System.out.println("formula.sqrt(25) = " + formula.sqrt(25));
        // добавьте в интерфейс метод по умолчанию на проверку четности
    }

    public static void lambdaExpressions() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        List<Person> people=new ArrayList();
        people.add(new Person("Dima", "Kuzin"));
        people.add(new Person("Vasya", "Pupkin"));
        people.add(new Person("Timur", "Perepopkin"));
        // так мы делали в Java 7
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // так мы делаем в Java 8
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(people,(a,b) -> b.firstName.compareTo(a.firstName));

        // можно короче
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        // и ещё короче
        Collections.sort(names, (a, b) -> b.compareTo(a));

        // короче только ссылка на метод
        Collections.sort(names, String::compareTo);

        System.out.println(names);
        // создайте список Person и отсортируйте их по firstName
    }

    public static void functionalInterface() {
//        функциональный интерфейс должен содержать ровно один абстрактный метод!!!
//        при этом может содержать сколько угодно методов по умолчанию
        Converter<String, Integer> converter = (param) -> Integer.valueOf(param);  // что здесь не хватает?
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        // а можно и проще, использовать ссылку на метод
        Converter<String, Integer> converter2 = Integer::valueOf;
        // так же можно и для объектов

        // написать лямбда функцию для даты в формате "dd.MM.yyyy"
        Converter<Date, String> converter3=(d)-> new SimpleDateFormat("dd.MM.yyyy").format(d);
    }

    public static void lambdaError() {
        // переменные используемые в лямбда должны быть final или хотя бы не изменяемыми, как в анонимных объектах
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
//        num = 3;

        // Внутри лямбда-выражений запрещено обращаться к методам по умолчанию
//        IFormula formula = (a, b) -> sqrt(a) + b;
    }

    public static void predicate() {
//        Предикаты — это функции, принимающие один аргумент, и возвращающие значение типа boolean.
//        Интерфейс содержит различные методы по умолчанию, позволяющие строить сложные условия (and, or, negate).
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));              // true
        System.out.println(predicate.negate().test("foo"));     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isNotEmpty.test("123"));

        // напишите Предикат на проверку четности
        Predicate<Integer> chetnost= (a)-> a%2==0;
    }

    public static void function() {
//        Функции принимают один аргумент и возвращают некоторый результат.
//        Методы по умолчанию могут использоваться для построения цепочек вызовов (compose, andThen).
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));     // "123"

        // напишите Функцию которая считает площадь окружности по его радиусу
        Function<Double,Double> ringSquare=(radius)->Math.PI*radius*radius;
    }

    public static void supplier() {
//        Поставщики (suppliers) предоставляют результат заданного типа.
//        В отличии от функций, поставщики не принимают аргументов.
        Supplier<Date> d = Date::new;
        d.get();   // new Date
    }

    public static void consumer() {
//        Потребители (consumers) представляют собой операции, которые производятся над одним входным аргументом.
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }

    public static void comparator() {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }

    public static void stream() {
//        Операции над потоками бывают или промежуточными (intermediate) или конечными (terminal)
//        Потоки создаются на основе источников, например типов, реализующих java.util.Collection
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        List<Integer> intCollection = Arrays.asList(8, 4, 7, 2, 0, 23, -5, -3, 45, -1, -4);

        List<Person> personCollection = Arrays.asList(
                new Person("Иван", "Николаевич"),
                new Person("Сергей", "Васильевич"),
                new Person("Георгий", "Петрович"));

        System.out.println("*************** filter *****************");
        // фильтрация данных
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // отфильтровать из stringCollection только те строки, которые заканчиваются на числа и получить сумму этих строк
//        stringCollection
//                .stream()
//                .filter((s) -> s.charAt(s.length()) > 0 && s.charAt(s.length()) < 9)
//                .forEach(System.out::println);

        System.out.println("*************** sorted *****************");
        // сортировка данных, он не меняет исходный список!
        intCollection
                .stream()
                .sorted()
                .forEach(System.out::print);
        System.out.println("\n" + intCollection);

        // 1. напишите свой comparator, чтобы результат был в обратном порядке.
        // 2. отсортируйте personCollection по фамилии
        personCollection
                .stream()
                .sorted((a,b)-> a.secondName.compareTo(b.secondName))
                .forEach(System.out::print);

        System.out.println("*************** map *****************");
        // Промежуточная операция map преобразовывает каждый элемент в другой объект при помощи переданной функции.
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // отфильтруйте intCollection так, чтобы остались только те элементы в которых есть цифра 3
        intCollection
                .stream()
                .map((a) ->a.toString())
               // .sorted((b) -> b.contains("3"))
                .forEach(System.out::print);

        System.out.println("*************** match *****************");
        streamMatch(stringCollection);

        System.out.println("*************** count *****************");
        // Операция Count является конечной операцией и возвращает количество элементов в потоке.
        // Типом возвращаемого значения является long.
        long startsWithB = stringCollection.stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);

        // посчитайте количество персон с именем более чем в 4 символа
        long moreThan4 =personCollection.stream()
                .filter((s)->s.firstName.length()>4)
                .count();

        System.out.println("*************** reduce *****************");
        // производит свертку элементов потока по заданной функции. Результатом является опциональное значение.
        Optional<String> reduced = stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        // посчитайте сумму отрицательных нечетных чисел из intCollection
        Optional<Integer> red=intCollection
                .stream()
                .filter((a)-> a<0&&a%2!=0)
                .reduce((s1,s2)->s1+s2);

        System.out.println("*************** parallelStream *****************");
        parallelStream();

    }

    public static void streamMatch(List<String> stringCollection) {
        // Для проверки, удовлетворяет ли поток заданному предикату, используются различные операции сопоставления (match).
        // Все операции сопоставления являются конечными и возвращают результат типа boolean.
        boolean anyStartsWithA = stringCollection.stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = stringCollection.stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection.stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
    }

    public static void parallelStream() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void maps() {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);  // позволяет нам не писать дополнительные проверки на null
        }
        map.forEach((id, val) -> System.out.println(val));  // принимает потребителя, который производит операцию над каждым элементом массива
        System.out.println("****************");

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33

        map.forEach((id, val) -> System.out.println(val));
        System.out.println("****************");

        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null

        map.forEach((id, val) -> System.out.println(val));
        System.out.println("****************");

        map.getOrDefault(42, "not found");  // not found

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }
}
