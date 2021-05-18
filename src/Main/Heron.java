// Copyright© by Fin

package Main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Heron {

    public static void main(String[] args) throws InterruptedException {

        // Eingabe des Radikanden
        Scanner Radikand_Input = new Scanner(System.in);
        System.out.print("Geben Sie einen beliebigen Radikand ein: ");                // (Minimum: -9,223,372,036,854,775,808)  -  Maximum: 9,223,372,036,854,775,807
        double Radikand = Radikand_Input.nextDouble();

        // Eingabe der Näherungszahl
        Scanner Näherungszahl_Input = new Scanner(System.in);
        System.out.print("Geben Sie eine Näherungszahl ein: ");
        double Näherungszahl = Näherungszahl_Input.nextDouble();                      // (Minimum: -9,223,372,036,854,775,808)  -  Maximum: 9,223,372,036,854,775,807

        // Eingabe der Anzahl der Nachkommastellen in *10er Schritten
        Scanner decimalPlaces_Input = new Scanner(System.in);
        System.out.print("Auf wie viele Nachkommastellen soll der Wurzelwert gerundet werden? (10 = 1, 100 = 2, ...): ");
        int decimalPlaces = decimalPlaces_Input.nextInt();                            //  (Minimum: -2147483648)  -  Maximum: 2147483647

        // Abfrage, ob vom Client (also man selbst) eingegebene Nachkommastellen Anzahl größer als 6 beträgt
        if (decimalPlaces > 1000000000) {                                             // Maximal 9 Nachkommastellen
            System.out.println("Value out of range!");
            TimeUnit.SECONDS.sleep(2);
            System.exit(0);
        } else {

            double Wandlung = Radikand / Näherungszahl;
            double Mittelwert = (Näherungszahl + Wandlung) / 2;
            Wandlung = Radikand / Mittelwert;
            double neuerMittelwert = (Mittelwert + Wandlung) / 2;

            // Wiederhole 100x
            for (int i = 0; i < 100; i++) {
                Wandlung = Radikand / neuerMittelwert;
                neuerMittelwert = (neuerMittelwert + Wandlung) / 2;
            }

            double Ergebnis_Wurzelwert_Step1 = Math.round(Wandlung * decimalPlaces);
            double Ergebnis_Wurzelwert_Step2 = Ergebnis_Wurzelwert_Step1 / decimalPlaces;
            System.out.println(Ergebnis_Wurzelwert_Step2);
        }
    }
}