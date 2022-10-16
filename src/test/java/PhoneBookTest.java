import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook phoneBook;



    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        phoneBook = new PhoneBook();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание теста");
        phoneBook = null;
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(
                Arguments.of(2, "Вася", "+7(905) 968-12-25", "Петя", "+7(905) 978-12-25"),
                Arguments.of(1, "Вася", "+7(905) 968-12-25", "Вася", "+7(905) 978-12-25")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAdd")
    void add_test(int expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, name2);
        Assertions.assertEquals(expected, phoneBook.add(name2, number2));
    }

    public static Stream<Arguments> sourceFindByNumber() {
        return Stream.of(
                Arguments.of("Вася", "Вася", "+7(905) 968-12-25", "Петя", "+7(905) 978-12-25"),
                Arguments.of("Вася", "Вася", "+7(905) 968-12-25", "Вася", "+7(905) 978-12-25")
        );
    }

    public static Stream<Arguments> sourceFindByName() {
        return Stream.of(
                Arguments.of("+7(905) 968-12-25", "Вася", "+7(905) 968-12-25", "Петя", "+7(905) 978-12-25"),
                Arguments.of("+7(905) 968-12-25", "Вася", "+7(905) 968-12-25", "Вася", "+7(905) 978-12-25")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceFindByNumber")
    void findByNumber_test(String expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        Assertions.assertEquals(expected, phoneBook.findByNumber(number1));
    }

    @ParameterizedTest
    @MethodSource("sourceFindByName")
    void findByName_test(String expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        Assertions.assertEquals(expected, phoneBook.findByName(name1));
    }

    public static Stream<Arguments> sourcePrintNames() {
        return Stream.of(
                Arguments.of(List.of("Вася", "Петя"), "Вася", "+7(905) 968-12-25", "Петя", "+7(905) 978-12-25"),
                Arguments.of(List.of("Вася", "Петя"), "Петя", "+7(905) 978-12-25", "Вася", "+7(905) 968-12-25"),
                Arguments.of(List.of("Вася"), "Вася", "+7(905) 968-12-25", "Вася", "+7(905) 978-12-25")
        );
    }

    @ParameterizedTest
    @MethodSource("sourcePrintNames")
    void printAllNames(List<String> names, String name1, String number1, String name2, String number2 ) {
        phoneBook.add(name1, number1);
        phoneBook.add(name2, number2);
        MatcherAssert.assertThat(names, Matchers.is(phoneBook.printAllNames()));
    }
}