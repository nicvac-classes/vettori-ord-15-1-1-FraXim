import java.util.Scanner;
import java.util.Random;

public class Program {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, val;
        System.out.println("Inserisci quante macchine hanno partecipato alla gara: ");
        n = in.nextInt();
        int[] p = new int[n];
        String[] nomi = new String[n];
        for (i = 0; i <= n - 1; i++) {
            System.out.println("Inserisci i nomi delle auto che hanno partecipato: ");
            nomi[i] = in.nextLine();
        }
        impostaVettoreRandom(p, n, nomi);
        bubbleSort(nomi, p, n);
        System.out.println("Ecco l'elenco di tutte le macchine ordinate in base alla classifica ordinata :");
        visualizzaVettori(nomi, p, n);
        System.out.println("RICERCA SEQUENZIALE");
        System.out.println("Inserisci la posizione della macchina la quale vuoi vedere il nome :");
        val = in.nextInt();
        i = ricercaSequenziale(p, n, val);
        if (i != -1) {
            System.out.println("Il nome della macchina che volevi sapere è: " + nomi[i]);
        } else {
            System.out.println("Valore non trovato");
        }
        System.out.println("RICERCA BINARIA");
        System.out.println("Inserisci la posizione della macchina la quale vuoi vedere il nome :");
        val = in.nextInt();
        i = ricercaBinaria(p, n, val);
        if (i != -1) {
            System.out.println("Il nome della macchina che volevi sapere è: " + nomi[i]);
        } else {
            System.out.println("Valore non trovato");
        }
    }
    
    public static void bubbleSort(String[] nomi, int[] p, int n) {
        int i, j, t;
        String c;
        boolean scambi;
        i = 0;
        scambi = true;
        while (i <= n - 1 && scambi == true) {
            scambi = false;
            j = 0;
            while (j <= n - 2 - i) {
                if (p[j] <= p[j + 1]) {
                    t = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = t;
                    c = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = c;
                    scambi = true;
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
    
    public static void impostaVettoreRandom(int[] p, int n, String[] nomi) {
        int i;
        for (i = 0; i <= n - 1; i++) {
            p[i] = random.nextInt(25) + 1;
            System.out.println("Posizione macchina " + nomi[i] + " non ordinata: " + p[i]);
        }
    }
    
    public static int ricercaBinaria(int[] p, int n, int pos) {
        int i, inizio, fine, centro, iTrovato, cont;
        inizio = 0;
        fine = n - 1;
        centro = (inizio + fine) / 2;
        iTrovato = -1;
        i = 0;
        cont = 0;
        while (pos != centro && inizio <= fine) {
            cont = cont + 1;
            if (pos > p[centro]) {
                inizio = centro + 1;
            } else {
                fine = centro - 1;
            }
            centro = (inizio + fine) / 2;
            if (pos == p[centro]) {
                iTrovato = centro;
            }
        }
        System.out.println("conti : " + cont);
        
        return iTrovato;
    }
    
    public static int ricercaSequenziale(int[] v, int n, int val) {
        int iTrovato, i, cont;
        i = 0;
        iTrovato = -1;
        cont = 0;
        while (i < n && iTrovato == -1) {
            cont = cont + 1;
            if (v[i] == val) {
                iTrovato = i;
            }
            i = i + 1;
        }
        System.out.println("conti : " + cont + " volte");
        
        return iTrovato;
    }
    
    public static void visualizzaVettori(String[] nomi, int[] p, int n) {
        int i;
        for (i = 0; i <= n - 1; i++) {
            System.out.println("La macchina " + nomi[i] + " è arrivato alla " + p[i] + "° posizione.");
        }
    }
}
