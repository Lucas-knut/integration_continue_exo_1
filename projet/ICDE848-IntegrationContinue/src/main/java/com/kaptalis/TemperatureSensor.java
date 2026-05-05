package com.kaptalis;
public class TemperatureSensor {
// VIOLATION PMD : Variable inutilisée
private String unusedVariable = "Audit_MedTech";
public boolean isSafe(double temperature) {
// VIOLATION PMD : Bloc if/else inutilement complexe ou vide
if (temperature > 100) {
// Bloc vide volontaire pour le test PMD
}
return (temperature >= 2.0 && temperature <= 8.0);
}
