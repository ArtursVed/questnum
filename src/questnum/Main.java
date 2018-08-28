package questnum;

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    static Random rand = new Random(); // peremennaja rand
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        int myNum = rand.nextInt(100) + 1;

        //nextInt -- vozvrasaet luboe cislo
        //nextInt(bound 100) --- ot 0 do 99 , bound pojavljaetsja avtomaticeski , posle vvoda 100
        //nextInt(100)+1 --- ot 1 do 100
        System.out.println(myNum);

        boolean userLost = true;

        for (int i = 0; i < 5 ; i++) {
            System.out.println("try" +i);
            int userNum = scan.nextInt();

           // String myNum;
          // i = JOptionPane.showInputDialog (null,"vvedite cislo");
           // System.out.println(i);
            // sravnivaem dannie - cisla

            if (myNum > userNum) {
                System.out.println("bigger");
            } else if (myNum <  userNum) {
                System.out.println("smaller");
            }
            else {
                System.out.println("good");
                userLost = false;
                break; // dlja togo , cto-bi dosrocno zakoncit programmu v slucai viigrasha
            }
        }
        if (userLost == true ) {
            System.out.println("YOU ARE LOOSER");

            // mozno i prosto (userLost) , tak kak eto boolen, toest oznacaet ili true ili false
        }
    }
}
