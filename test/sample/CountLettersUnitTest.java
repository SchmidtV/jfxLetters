package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CountLettersUnitTest extends Model {

    private Model m;
    @BeforeEach
    void setUp() {
        m = new Model();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCountSingleLetterMaxCount() {
        Map<Character, Integer> output = m.countLetters("aaafghj");
        Assertions.assertEquals(output.get('a'), 3);
        Assertions.assertFalse(output.containsKey('f'));
        Assertions.assertFalse(output.containsKey('g'));
        Assertions.assertFalse(output.containsKey('h'));
        Assertions.assertFalse(output.containsKey('g'));
    }

    @Test
    void testCountCapitalLetters() {
        //string containing 4 A's
        Map<Character, Integer> output = m.countLetters("aaCfghAAg");
        Assertions.assertEquals(output.get('a'), 4);
    }

    @Test
    void testCountMultipleLettersMaxCount() {
        Map<Character, Integer> output = m.countLetters("aaafffgg");
        Assertions.assertEquals(output.get('a'), 3);
        Assertions.assertEquals(output.get('f'), 3);
    }

    @Test
    void testCountEmptyString() {
        Map<Character, Integer> output = m.countLetters("");
        Assertions.assertNotNull(output);
        Assertions.assertEquals(output.size(), 0);
    }

    @Test
    void testCountSpacesOnlyString() {
        Map<Character, Integer> output = m.countLetters("   ");
        Assertions.assertNotNull(output);
        Assertions.assertFalse(output.containsKey(' '));
        Assertions.assertEquals(output.size(), 0);
    }

    @Test
    void testCountNumbers() {
        Map<Character, Integer> output = m.countLetters("1114567222");
        Assertions.assertEquals(output.get('1'), 3);
        Assertions.assertEquals(output.get('2'), 3);
        Assertions.assertFalse(output.containsKey('4'));
    }

    @Test
    void testCountSpecialChars() {
        Map<Character, Integer> output = m.countLetters(".,-_!\"§$%& ()/\\=*+");
        Assertions.assertEquals(output.get('.'), 1);
        Assertions.assertEquals(output.get(','), 1);
        Assertions.assertEquals(output.get('-'), 1);
        Assertions.assertEquals(output.get('_'), 1);
        Assertions.assertEquals(output.get('!'), 1);
        Assertions.assertEquals(output.get('\"'), 1);
        Assertions.assertEquals(output.get('$'), 1);
        Assertions.assertEquals(output.get('%'), 1);
        Assertions.assertEquals(output.get('&'), 1);
        Assertions.assertEquals(output.get('/'), 1);
        Assertions.assertEquals(output.get('('), 1);
        Assertions.assertEquals(output.get(')'), 1);
        Assertions.assertEquals(output.get('\\'), 1);
        Assertions.assertEquals(output.get('='), 1);
        Assertions.assertEquals(output.get('*'), 1);
        Assertions.assertEquals(output.get('+'), 1);
        Assertions.assertNull(output.get(' '));
    }
}