package questnum;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
//import javax.swing.*;

public class Main {
    static Random rand = new Random(); // peremennaja rand
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();
    private static Object loadResults;

    public static void main(String[] args) {


        loadResults();

        String answer;

        do {

            String name;
            System.out.println("what is your name?");
            name = scan.next();
            System.out.println("Hello " + name);

            long t1 = System.currentTimeMillis();
            // write your code here
            int myNum = rand.nextInt(100) + 1;

            //nextInt -- vozvrasaet luboe cislo
            //nextInt(bound 100) --- ot 0 do 99 , bound pojavljaetsja avtomaticeski , posle vvoda 100
            //nextInt(100)+1 --- ot 1 do 100
            System.out.println(myNum);

            boolean userLost = true;

            for (int i = 0; i < 5; i++) {
                System.out.println("try" + i);
                int userNum = askNUM();

                // String myNum;
                // i = JOptionPane.showInputDialog (null,"vvedite cislo");
                // System.out.println(i);
                // sravnivaem dannie - cisla

                if (myNum > userNum) System.out.println("bigger");
                else if (myNum < userNum) {
                    System.out.println("smaller");
                } else {
                    System.out.println("good");
                    userLost = false;



                    GameResult r = new GameResult();
                    r.name = name;
                    r.triescount = i+1;


                    long t2 = System.currentTimeMillis();
                    long tdt = ((t2 - t1)/1000) ;
                    System.out.println ("playing time " + tdt + " seconds");
                    r.tdt = tdt;
                    results.add(r);
                    break; // dlja togo , cto-bi dosrocno zakoncit programmu v slucai viigrasha

                }

            }
            if (userLost == true) {
                System.out.println("YOU ARE LOOSER");


                // mozno i prosto (userLost) , tak kak eto boolen, toest oznacaet ili true ili false
            }
            System.out.println("Do you want play again? (y/n)");
            answer = askYN();

        }

        while (answer.equals("yes"));

        showResults();
        saveResults();
        


        System.out.println("Good buy");



    }
        // citaem znacenie predidusii i dobovljaem novie
    private static void loadResults() {
        File file = new File("top_scores.txt");
                try(Scanner in = new Scanner(file)){

                    while(in.hasNext()) {
                        GameResult result = new GameResult();
                        result.name = in.next();
                        result.triescount = in.nextInt();
                        result.tdt = in.nextLong();
                        results.add(result);
                    }
                }

           catch (IOException e){
                System.out.println("Cannot save the file");
        }
    }

    private static void saveResults() {
        //sozdaem txt fail s rezultatami i vivodim no ne na ekran , a v fail
        File file = new File("top_scores.txt");
        // PrintWriter out = null;
        try (PrintWriter out = new PrintWriter(file)){
            for (GameResult r : results){
                out.printf( "%s %d %d\n", r.name, r.triescount, r.tdt );
            }
        }catch (IOException e){
            System.out.println("Cannot save the file");
        }
    }



    private static void showResults() {
        for (GameResult r : results){
            System.out.printf ("%s - %d - %dsec\n", r.name, r.triescount, r.tdt );

        }
    }

    static String askYN() {    // v dannom slucae vozvrasaet dannie
        String answer;  // oboznacaem peremennuju
        do {
            answer = scan.next();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("You can enter only 'yes' or 'no' ");
                //   continue; // nacni cikl snacalo
            } else {
                return answer;
            }
        }

        while (true);
        //  while (!answer.equals("yes") && !answer.equals("no"));   // && -- i ; i ne yes i NO


    }

    static int askNUM() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("This isn't a number");
                scan.next();
                continue;
            }
            if (answer < 1 || answer > 100) {  // || -- ili
                System.out.println(" You can enter number from '1' to '100' ");

            } else {
                return answer;
            }

        }

        while (true);
    }

}

