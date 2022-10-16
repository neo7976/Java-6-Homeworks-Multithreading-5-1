import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void add_test() {
        String name = "Вася";
        String number = "+7(905) 968-12-25";
        int expected = 1;
        Assertions.assertEquals(expected, phoneBook.add(name, number));
    }
}