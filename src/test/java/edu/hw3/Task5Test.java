package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw3.Task5.Contact;
import static edu.hw3.Task5.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Ordinary test 1")
    void ordinaryTest1() {
        List<String> namesList = List.of( "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        List<Contact> expectedAnswer = List.of(
            new Contact("Thomas", "Aquinas"),
            new Contact("Rene", "Descartes"),
            new Contact("David", "Hume"),
            new Contact("John", "Locke")
        );

        List<Contact> actualAnswer = parseContacts(namesList, "ASC");

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("Ordinary test 2")
    void ordinaryTest2() {
        List<String> namesList = List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        List<Contact> expectedAnswer = List.of(
            new Contact("Carl", "Gauss"),
            new Contact("Leonhard", "Euler"),
            new Contact("Paul", "Erdos")
        );

        List<Contact> actualAnswer = parseContacts(namesList, "DESC");

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("Null test")
    void nullTest() {
        List<String> namesList = List.of("Paul Erdos", "Leonhard Euler", "Carl");
        List<Contact> expectedAnswer = List.of(
            new Contact("Leonhard", "Euler"),
            new Contact("Paul", "Erdos"),
            new Contact("Carl", null)
        );

        List<Contact> actualAnswer = parseContacts(namesList, "DESC");

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("Empty test 1")
    void emptyTest1() {
        List<String> namesList = List.of();
        List<Contact> expectedAnswer = List.of();

        List<Contact> actualAnswer = parseContacts(namesList, "DESC");

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("Empty test 2")
    void emptyTest2() {
        List<String> namesList = null;
        List<Contact> expectedAnswer = List.of();

        List<Contact> actualAnswer = parseContacts(namesList, "DESC");

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }


}
