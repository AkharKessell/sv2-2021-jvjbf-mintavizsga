package aquarium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumTest {
    Aquarium aquarium;
    Fish clownfish;
    Fish tang;
    Fish kong;

    @BeforeEach
    void start() {

        clownfish = new Clownfish("Clownfish", 10, "x");
        tang = new Tang("Tang", 5, "y");
        kong = new Kong("Kong", 6, "z");
        aquarium = new Aquarium();
        aquarium.addFish(clownfish);
        aquarium.addFish(tang);
        aquarium.addFish(kong);
    }

    @Test
    void test_Capacity() {
        assertEquals(20, Aquarium.CAPACITY);
    }

    @Test
    void test_GetNumberOfFishWhichForgets() {
        assertEquals(1, aquarium.getNumberOfFishWithMemoryLoss());
    }
    @Test
    void test_AddFish() {
        Clownfish otherClownfish = new Clownfish("Clownfish2", 3, "v");
        aquarium.addFish(otherClownfish);
        assertEquals(4, aquarium.getStatus().size());
    }

}
