package uniquefinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueFinderTest {

    UniqueFinder uniqueFinder;
    List<Character> expected;

    @BeforeEach
    void init() {
        uniqueFinder = new UniqueFinder();
        expected = new ArrayList<>();
    }

    @Test
    void test_uniqueChars_normalAlphabet() {
        expected.add('a');
        expected.add('b');
        expected.add('c');
        assertEquals(expected, uniqueFinder.getUniqueChars("abc"));
    }

    @Test
    void test_uniqueChars_null_IAE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> uniqueFinder.getUniqueChars(null));
        assertEquals("Null.", exception.getMessage());
    }

    @Test
    void test_uniqueChars_withSCharacter_andUpper() {
        expected.add('J');
        expected.add('á');
        expected.add('V');
        expected.add('@');
        assertEquals(expected, uniqueFinder.getUniqueChars("JáV@"));
    }
}
