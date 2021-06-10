import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
    	// arrange
        final String[] EXPECTED = {"X", "Y", "Z"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"x", "y", "z"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
    	// arrange
        final int EXPECTED = 3;

        // act
        final int actual = CodeTest.findWordCount("cat dog cat horse octopus dog cat", "cat");

        // assert
        assertEquals(EXPECTED, actual);
    }

    @Test
    public void composeU_returnsExpectedResult() {
    	// arrange
        final int EXPECTED = 6;

        // act
        Function<Integer, Integer> f = CodeTest.composeU(x -> x + 1, x -> x * 2);
        final int actual = f.apply(2);

        // assert
        assertEquals(EXPECTED, actual);
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
    	// arrange
    	final ByteArrayOutputStream systemOutRedirected = new ByteArrayOutputStream();
    	final PrintStream originalSystemOut = System.out;
    	final String EXPECTED = "This is\r\na test of\r\nreading a file.\r\nGood bye!\r\n";
    	
    	// act
    	System.setOut(new PrintStream(systemOutRedirected));
    	CodeTest.writeContentsToConsole();
    	System.setOut(originalSystemOut);
    	
    	// assert
    	assertEquals(EXPECTED, systemOutRedirected.toString());
    }

    @Test
    public void handleInvalidArgument_returnsExpectedResult() {
    	// arrange
        final String EXPECTED = "Integer too big (100)";
    	
    	try {
    	// act
    		CodeTest.handleInvalidArgument();
    		fail();
        } catch (IllegalArgumentException ex) {
        // assert
        	assertEquals(EXPECTED, ex.getMessage());
        }
    }
    
    @Test
    public void puzzle_returnsExpectedResult() {
    	// arrange
    	final ByteArrayOutputStream systemOutRedirected = new ByteArrayOutputStream();
    	final PrintStream originalSystemOut = System.out;
    	final String EXPECTED = "1,2,3,3,'Snap'";
    	
    	// act
    	System.setOut(new PrintStream(systemOutRedirected));
    	CodeTest.puzzle();
    	System.setOut(originalSystemOut);
    	
    	// assert
    	assertEquals(EXPECTED, systemOutRedirected.toString());
    }
}
