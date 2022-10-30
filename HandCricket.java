import java.util.*;
public class HandCricket
{
    
    static int numRandom()
    {
        double randBot=Math.random();
        int run;

        if(randBot>0 && randBot<=0.16667)
            run=1;
        else if(randBot>0.16667 && randBot<=0.3333)
            run=2;
        else if(randBot>0.3333 && randBot<=0.5)
            run=3;
        else if(randBot>0.5 && randBot<=0.6667)
            run=4;
        else if(randBot>0.6667 && randBot<=0.8333)
            run=5;
        else
            run=6;


        return run;
    }

    static int numUser(Scanner sc)
    {
        System.out.print("\nEnter a number between 1-6: ");
        int num = sc.nextInt();


        while(num > 6 || num < 1)
        {
            System.out.print("Invalid number entered... Enter a number between 1-6: ");
            num = sc.nextInt();
        }
        
        return num;

    }



    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice:");
        System.out.println("1)Batting");
        System.out.println("2)Bowling");

        int choice = sc.nextInt();
        int countUser = 0,countBot = 0;

        while(choice != 1 && choice != 2)
        {
            System.out.println("INVALID INPUT");

            System.out.println("Press 1 for batting");
            System.out.println("Press 2 for bowling");

            choice = sc.nextInt();
        }

        switch(choice)
        {
            case 1:
            {
                int userRun = numUser(sc);
                int botRun = numRandom();
                while(userRun != botRun)
                {
                    countUser = countUser + userRun;

                    System.out.println("Bot chose: " + botRun);

                    System.out.println("Your score is : " + countUser);

                    userRun = numUser(sc);
                    botRun = numRandom();
                }

                System.out.println("Player OUT! Your score is : " + countUser +" Bot's turn...");
                System.out.println("----------------------------------");

                botRun = numRandom();
                boolean out = false;
                boolean won = false;
                
                while(numUser(sc) != botRun)
                {
                    if(out == false)
                        out = true;
                    System.out.println("Bot chose :" + botRun);
                    countBot = countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);
                    System.out.println("-------------------");
                    
                    if(countBot > countUser)
                    {
                        //   ch=1;
                        won = true;
                        break;
                    }
                    botRun = numRandom();
                }
                
                if(!won){
                    System.out.println("Bot OUT! Bot's total score is: " + countBot + "\n RESULTS ARE BELOW");
                    break;
                }
                if(!out)
                        System.out.println("Bot chose: " + botRun);               
                break;
            }

            case 2:
            {
                int botRun = numRandom();

                while(numUser(sc) != botRun)
                {
                    System.out.println("Bot chose :" + botRun);
                    countBot=countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);
                    System.out.println("-------------------");
                    
                    botRun = numRandom();
                }

                // System.out.println("Bot chose :"+temp1);
                System.out.println("Bot OUT! Bot's total score is: " + countBot + " User's turn...");
                System.out.println("------------------------");

                int userRun = numUser(sc);
                botRun = numRandom();
                boolean won = false;
                boolean out = false;
                while(userRun != botRun)
                {
                    if(out == false)
                        out = true;
                    countUser = countUser + userRun;

                    System.out.println("Bot chose: " + botRun);
                    System.out.println("Player's score is: " + countUser);

                    if(countBot < countUser)
                    {
                        //ch=1;
                        won = true;
                        break;
                    }
                    botRun = numRandom();
                    userRun = numUser(sc);
                }
                if(!won)
                {
                    if(!out)
                        System.out.println("Bot chose: " + botRun);
                    // if(ch==1)
                    // System.out.println("Score reached \n RESULTS ARE BELOW");
                    System.out.println("Player OUT! Your score is :" + countUser + "\nRESULTS ARE BELOW");
                }
                break;
            } 

            default:
                System.out.println("INVALID INPUT");
        }

        System.out.println("Player's score:\t Bot's score:");
        System.out.println(countUser+"\t \t " + countBot);

        if(countUser > countBot)
        {
            System.out.println("Player won by "+(countUser-countBot)+" runs");
        }
        else if(countUser == countBot)
        {
            System.out.println("DRAW");
        }
        else
        {
            System.out.println("Bot won by " +(countBot-countUser) +" runs");
        }

        System.out.println("-------------------------------");

    }
}