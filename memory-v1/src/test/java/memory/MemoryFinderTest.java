package memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryFinderTest {

    @Test
    void get() {
        MemoryFinder memoryFinder = new MemoryFinder();
        Memory memory = memoryFinder.get();
        assertNotNull(memory);
        assertTrue(memory.getUsed() > 0);
        assertTrue(memory.getMax() > 0);
    }
}