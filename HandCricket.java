import java.util.*;
 public class HandCricket
{
    int numRandom()
    {
        double randBot=Math.random();
        int run;     

        if(randBot>0 && randBot<=0.16667)
            run=1;
        else if(randBot>1.6667 && randBot<=0.3333)
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
    
    int numUser(Scanner sc)
    {
        System.out.print("Enter a number between 1-6: ");
        int num = sc.nextInt();

        System.out.println();
        
        while(num > 6 || num < 1)
        {
            System.out.print("Enter a number between 1-6: ");
            num = sc.nextInt();
        }
        System.out.println();
        return num;
    
    }
           
            
            
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Press 1 for batting");
        System.out.println("Press 2 for bowling");

        int choice = sc.nextInt();
        int countUser = 0,countBot = 0      
        
        while(choice != 1 || choice != 2)
        {
            System.out.println("INVALID INPUT");
            choice = sc.nextInt();
        }

        switch(choice)
        {
            case 1:
            {
                int userRun = numUser(sc);

                while(userRun != numRandom())
                {
                    countUser=countUser+userRun;
                    System.out.println("Your score is : "+count);

                    userRun = numUser(sc);
                }

                System.out.println("Player OUT! Your score is : " + countUser +" Bot's turn...");
                System.out.println("----------------------------------");

                int botRun = numRandom()
                while(numUser(sc) != botRun)
                {
                    System.out.println("Bot chose :" + botRun);
                    countBot = countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);

                    if(countBot>countUser)
                    {
                    //   ch=1;        
                      break;
                    }
                    botRun = numRandom();
                }
                
                System.out.println("Bot OUT! Bot's score is :"+countBot+"\n RESULTS ARE BELOW");
              }
            break;
            case 2:
            {

                int botRun = numRandom();
                
                while(numUser(sc) != botRun)
                {
                    System.out.println("Bot chose :" + botRun);
                    countBot=countBot + botRun;
                    System.out.println("Bot's score is :" + countBot);

                    botRun = numRandom();
                }

                // System.out.println("Bot chose :"+temp1);
                System.out.println("Bot OUT! Bot's score is :" + countBot + " User's turn...");
                System.out.println("------------------------");

                int userRun = numUser(sc);
                while(userRun != numRandom())
                {
                    countUser=countUser + userRun;
                    System.out.println("Player's score is : " + countUser);
                    if(countBot < countUser)
                    {
                        //ch=1;
                        break;
                    }
                }
                // if(ch==1)
                // System.out.println("Score reached \n RESULTS ARE BELOW");
                System.out.println("Player OUT!Your score is :" + countUser + "\n RESULTS ARE BELOW");
            
            }
            
            default:
                System.out.println("INVALID INPUT");
        }

        System.out.println("User's score:\t Bot's score:");
        System.out.println(countUser+"\t \t" + countBot);

        if(countUser > countBot)
        {
            System.out.println("User won by "+(countUser-countBot)+" runs");
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
                    
       
        
        
        
