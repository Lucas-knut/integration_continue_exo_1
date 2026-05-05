package com.kaptalis;
public class TemperatureSensor {
// Norme de sécurité : entre 2.0°C et 8.0°C
public boolean isSafe(double temperature) {
return (temperature >= 2.0 && temperature <= 8.0);
}
}