package esercizio.listaDesideri;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ListaRegali {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> listaRegali = readListaDesideri();

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
        writeListaDesideri(listaRegali);
        System.out.println("Ecco la lista dei regali ordinata:");

        for (int i = 0; i < listaRegali.size(); i++) {
            if (i == listaRegali.size() - 1) {
                System.out.print(listaRegali.get(i) + ".");
            } else {
                System.out.print(listaRegali.get(i) + ", ");
            }
        }
    }

    public static void writeListaDesideri (ArrayList<String> listaRegali) {
        File file = new File("./Resources/data.txt");
        try(FileWriter fw = new FileWriter(file)) {
            for (String regalo : listaRegali){
                fw.write(regalo + "\n") ;
            }
        }catch (IOException e) {
            System.out.println("File non trovato!");
        }
    }

    public static ArrayList<String> readListaDesideri () throws Exception {
        File file = new File("./Resources/data.txt");
        ArrayList<String> listaRegali = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                listaRegali.add(scanner.nextLine());
            }
            return listaRegali;
        } catch (IOException e) {
            throw new Exception("File non trovato!");
        }
    }
}

