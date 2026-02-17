package com.example.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    
    @Test
    public void testAppExists() {
        App app = new App();
        assertNotNull(app);
    }
    
    @Test
    public void testMain() {
        // Test that main method runs without exceptions
        try {
            App.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            fail("Main method threw exception: " + e.getMessage());
        }
    }
}