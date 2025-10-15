import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Ass_01_Craps
{
    public static void main(String[] args)
    {
        int die1 = 0;
        int die2 = 0;
        int rollVal = 0;
        int point = 0;
        int newRollVal = 0;

        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean donePlaying = false;
        boolean rollingForPoint = false;
        String againQuestion = "";

        do
        {
            die1 = rnd.nextInt(5) + 1;
            die2 = rnd.nextInt(5) + 1;
            rollVal = die1 + die2;

            switch (rollVal)
            {
                case 2:
                case 3:
                case 12:
                    System.out.println("LOSE");
                    rollingForPoint = false;
                    break;
                case 7:
                case 11:
                    System.out.println("WIN INSTANT");
                    rollingForPoint = false;
                    break;
                default:
                    point = rollVal;

                    do {
                        die1 = rnd.nextInt(5) + 1;
                        die2 = rnd.nextInt(5) + 1;
                        newRollVal = die1 + die2;

                        if (newRollVal == 7)
                        {
                            System.out.println("CRAP OUT");
                            rollingForPoint = false;
                        }
                        else if (newRollVal == 12)
                        {
                            System.out.println("INSTANT WIN");
                            rollingForPoint = true;
                        }
                        else if (newRollVal == point)
                        {
                            System.out.println("GOT A POINT: YOU WIN");
                            rollingForPoint = false;
                        }
                        else
                        {
                            System.out.println("CONT ROLLING");
                        }
                    }while (rollingForPoint);
            }

            System.out.println("Do you want to play again: [Y/N]");
            againQuestion = in.nextLine().toUpperCase();
            if (againQuestion.equals("Y"))
            {
                donePlaying = false;
            }
            else
            {
                donePlaying = true;
            }
        }while (!donePlaying);
    }

}
