package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Conversor {
    private String base;
    private HashMap<String, Double> results;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Double> getResults() {
        return results;
    }

    public void setResults(HashMap<String, Double> results) {
        this.results = results;
    }

    public static void exibir(Conversor conversor){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    ************************************
                    Bienvenido al conversor de monedas. Elija una opción
                    1)Dólar a peso colombiano
                    2)Peso colombiano a dólar
                    3)Dólar a peso mexicano
                    4)Peso mexicano a dólar
                    5)Dólar a Euro
                    6)Euro a dólar
                    7)Salir
                    """);
            opcion = scanner.nextInt();

            switch(opcion){
                case 1 -> convertir(conversor, "COP");
                case 2 -> convertirInverso(conversor, "COP");
                case 3 -> convertir(conversor, "MXN");
                case 4 -> convertirInverso(conversor, "MXN");
                case 5 -> convertir(conversor, "EUR");
                case 6 -> convertirInverso(conversor, "EUR");
                case 7 -> System.out.println("Hasta luego");
                default -> System.out.println("Opción inválida!!");
            }
        } while (opcion!=7);

 }
 private static void convertir(Conversor conversor, String monedaDestino){
        Scanner scanner = new Scanner(System.in);
     System.out.print("Ingrese la cantidad en " + conversor.getBase() + ": ");
     Double cantidad = scanner.nextDouble();
     Double tasa = conversor.getResults().getOrDefault(monedaDestino, 0.0);
     System.out.printf("Resultado  %.2f %s%n: ", cantidad*tasa, monedaDestino);
 }

 private static  void convertirInverso(Conversor conversor, String monedaOrigen){
        Scanner scanner = new Scanner(System.in);
     System.out.print("Ingrese la cantidad en " + monedaOrigen + ": ");
     Double cantidad = scanner.nextDouble();
     Double tasa = conversor.getResults().getOrDefault(monedaOrigen, 0.0);

     if(tasa!=0.0){
         System.out.printf("Resultado  %.2f %s%n: ", cantidad / tasa, conversor.getBase());
     } else{
         System.out.println("No se pudo encontrar la tasa");

     }
 }
}
