package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessStringTest extends Model {

    private Model m;
    @BeforeEach
    void setUp() {
        m = new Model();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullString() {
        String output = m.processString(null);
        Assertions.assertEquals("The input text cannot be read properly.", output);
    }

    @Test
    void testEmptyString() {
        String output = m.processString("");
        Assertions.assertEquals("Type some text for me to count!", output);
    }

     @Test
     void test10MillLongString() {
        String veryLongString = new String(new char[1000000]).replace("\0", "1234567890");
        String output = m.processString(veryLongString);
         Assertions.assertEquals("The input text is too long. Maximal length of 5 million chars are allowed.", output);
    }
    @Test
     void testNormalString() {
        String output = m.processString("test11111");
        Assertions.assertTrue(output.contains("1 with 5 occurrences"));
    }

}