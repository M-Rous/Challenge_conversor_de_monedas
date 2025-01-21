package principal;

import modelos.MonedaCambio;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean continuar = true;
        Scanner lec = new Scanner(System.in);


        System.out.println("**************************************");
        System.out.println("--------------------------------------");
        System.out.println("Bienvenido/a al conversor de monedas" + "\n");


        String menu = "1) Dólar -->  Peso Mexicano" + "\n" +
                      "2) Peso Mexicano -->  Dólar" + "\n" +
                      "3) Dólar -->  Euro" + "\n" +
                      "4) Euro -->  Dólar" + "\n" +
                      "5) Dólar -->  Peso Argentino" + "\n" +
                      "6) Peso Argentino -->  Dólar" + "\n" +
                      "7) Salir" + "\n"+"\n"+"\n"+

                    "--------------------------------------";

        while (continuar) {
            ConvertirMoneda convertir = new ConvertirMoneda();
            System.out.println(menu);
            System.out.println("De las siguientes, elije una opción: ");
            System.out.println("**************************************");
            int opcion = 0;
            opcion = lec.nextInt();
            String monedaOrigen = "", monedaDestino = "";
            double monto = 0;

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas.");
                continuar = false;


            }

            switch (opcion) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "MXN";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 2:
                    monedaOrigen = "MXN";
                    monedaDestino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();

                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "EUR";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 4:
                    monedaOrigen = "EUR";
                    monedaDestino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 6:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    System.out.println("Ingrese la cantidad a convertir ");
                    monto = lec.nextDouble();
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor de monedas ");
                    System.exit(0);
                    break;
                default: {
                    System.out.println("Por favor, selecciona un número entre 1 y 7.\n");
                    continue;
                }
            }
            if (opcion >= 1 && opcion <= 6) {
                double resultado = convertir.convertir(monedaOrigen, monedaDestino, monto);
                System.out.println("El valor de " + monto + " [" + monedaOrigen + "] corresponde a " + resultado + " [" + monedaDestino + "]\n");
            }
        }

    }

}
