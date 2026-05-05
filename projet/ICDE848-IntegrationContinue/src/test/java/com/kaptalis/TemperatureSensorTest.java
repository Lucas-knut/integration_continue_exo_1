package com.kaptalis;
import static org.junit.Assert.*;
import org.junit.Test;
public class TemperatureSensorTest {
@Test
public void testTemperatureNormal() {
TemperatureSensor sensor = new TemperatureSensor();
assertTrue("La température de 5°C devrait être valide",
sensor.isSafe(5.0));
}
@Test
public void testTemperatureTooCold() {
TemperatureSensor sensor = new TemperatureSensor();
assertFalse("La température de 1°C devrait être invalide",
sensor.isSafe(1.0));
}
}