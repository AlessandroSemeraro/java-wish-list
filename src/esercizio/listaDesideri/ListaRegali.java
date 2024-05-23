package esercizio.listaDesideri;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ListaRegali {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> listaRegali = new ArrayList<>();

        while (true) {
            System.out.println("Inserisci il regalo che vuoi aggiungere: ");
            String regalo = scanner.nextLine();

            if ( regalo.equals("stop")) {
                break;
            }

            listaRegali.add(regalo);

            System.out.println("La lista contiene " + listaRegali.size() + (listaRegali.size() == 1 ? " regalo." : " regali."));

            System.out.println("Vuoi continuare ad aggiungere regali? (scrivi 'si' per continuare o 'stop' per fermarti)");

            String risposta = scanner.nextLine();

            if (risposta.equals("si")) {
                //continua
            } else {
                break;
            }
        }

        Collections.sort(listaRegali);
        System.out.println("Ecco la lista dei regali ordinata:");

        for (int i = 0; i < listaRegali.size(); i++) {
            if (i == listaRegali.size() - 1) {
                System.out.print(listaRegali.get(i) + ".");
            } else {
                System.out.print(listaRegali.get(i) + ", ");
            }
        }
    }
}

