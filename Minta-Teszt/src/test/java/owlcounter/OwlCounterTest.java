package owlcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OwlCounterTest {

    OwlCounter owlCounter;

    @BeforeEach
    void start() {
        owlCounter = new OwlCounter();
        Path path = Paths.get("src/test/resources/owls_in_hungary_by_county.txt");
        owlCounter.readFromFile(path);
    }

    @Test
    void test_GetNumberOfOwls() {
        assertEquals(1000, owlCounter.getNumberOfOwls("Bács-Kiskun"));
        assertEquals(980, owlCounter.getNumberOfOwls("Békés"));
        assertEquals(1050, owlCounter.getNumberOfOwls("Baranya"));
    }

    @Test
    void test_ReadFromFileWithWrongPath() {
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> new OwlCounter().readFromFile(Paths.get("src/test/resources/owls_in_hungary_by_country.txt")));
        assertEquals("Can not read file.", exception.getMessage());
    }

    @Test
    void test_GetNumberOfOwlsWithWrongCounty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> owlCounter.getNumberOfOwls("Somog"));
        assertEquals("N.A.", exception.getMessage());
    }

    @Test
    void test_GetNumberOfAllOwls() {
        assertEquals(11410, owlCounter.getNumberOfAllOwls());
    }
}