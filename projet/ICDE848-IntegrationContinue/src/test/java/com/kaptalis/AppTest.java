package com.kaptalis;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;


public class AppTest {
    @Test
    public void testTemperatureCorrect() {
        assertTrue(App.isTemperatureValid(5.0));
        
        // ICI : On attend que 5.0 soit VALIDE (true), 
        // mais on demande à JUnit de vérifier que c'est FAUX (assertFalse).
        // Cela va provoquer une erreur de test.
        //assertFalse(App.isTemperatureValid(5.0));
    }


    @Test
    public void testTemperatureTooHigh() {
        assertFalse(App.isTemperatureValid(10.0));
    }
}
