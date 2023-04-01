import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Teste {

    public static void main(String[] args) {

        List<String> lista = Arrays.asList("um", "dois", "tres", "quatro", "cinco");

        // Criando um Stream a partir da lista, usando o método stream()
        Stream<String> stream = lista.stream();

        // Aplicando operações ao Stream sem precisar de uma lista intermediária
        stream.filter(s -> s.startsWith("d"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
