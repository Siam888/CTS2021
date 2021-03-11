package ro.ase.acs.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import ro.ase.acs.classes.Sum;
import ro.ase.acs.interfaces.BinaryOperator;
import ro.ase.acs.interfaces.Moveable;
import ro.ase.acs.interfaces.UnaryOperator;

public class Main {

    public static int transform(int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return 2 * x;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        BinaryOperator operator;

        if (random.nextInt() % 2 == 0) {
            operator = new Sum();
        } else {
            operator = (operand1, operand2) -> operand1 - operand2;
        }

        System.out.println(operator.operate(5, 3));

        Sum suma = new Sum();
        suma.operate(3, 2);

        operator = (operand1, operand2) -> operand1 * operand2;
        System.out.println(operator.operate(3, 5));

        Moveable m = () -> System.out.println("The car is moving");
        m.move();

        UnaryOperator op = o -> ++o;
        System.out.println(op.operate(5));

        List<Integer> list;
        list = Arrays.asList(3, 4, 1, 5, 1, 8, 12);
        long numarNumerePare = 0;
        numarNumerePare = list.stream().filter(e -> (e % 2 == 0)).count();
        System.out.println(numarNumerePare);

        List<Integer> listaSortata;
        listaSortata = list.stream().distinct().
                filter(e -> e < 8).sorted().collect(Collectors.toList());
        for (Integer elementLista : listaSortata) {
            System.out.println(elementLista);
        }

        List<String> stringList = Arrays.asList("something", "something else", "a", "ab", "abc");
        String stringFiltrat;
        stringFiltrat = stringList.stream().
                filter(s -> s.length() > 2)
                .collect(Collectors.joining(", "));
        System.out.println(stringFiltrat);

        list.stream().distinct().sorted().map(e -> e * e).forEach(e -> System.out.println(e));

        random.ints().limit(5).sorted().forEach(System.out::println);

        list.stream().map(Main::transform).forEach(System.out::println);

        String filteredList = stringList.parallelStream().
                filter(e -> e.startsWith("a")).collect(Collectors.joining(", "));
        System.out.println(filteredList);
    }

}
