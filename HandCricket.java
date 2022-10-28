import java.util.*;
 public class HandCricket
{
    int temp=0,temp1=0;
    Scanner ob=new Scanner(System.in);
    int Run()
    {
        double randBot=(Math.random());
        int run;        
        if(randBot>0 && randBot<=0.16667)
        run=1;
        else
        if(randBot>1.6667 && randBot<=0.3333)
        run=2;
        else
        if(randBot>0.3333 && randBot<=0.5)
        run=3;
        else
        if(randBot>0.5 && randBot<=0.6667)
        run=4;
        else
        if(randBot>0.6667 && randBot<=0.8333)
        run=5;
        else
        run=6;
        temp1=run;
        
        return run;
    }
    
        int User()
        {
            System.out.println("Enter a number between 1-6");
            int num=ob.nextInt();
            temp=num;
            return num;
            //condition for not bw 1 and 6
        }
           
            
            
        
    void f()
    {
        
        System.out.println("Press 1 for batting");
        System.out.println("Press 2 for bowling");
        int sw=ob.nextInt();
        int count=0,countBot=0,ch=0;      
        switch(sw)
        {
            case 1:
            {
                while(User()!=Run())
                {
                    count=count+temp;
                    System.out.println("User score is :"+count);
                }
                System.out.println("User OUT!Your score is :"+count+" Bot's turn");
                System.out.println("----------------------------------");
                while(User()!=Run())
                {
                    System.out.println("Bot chose :"+temp1);
                    countBot=countBot+temp1;
                    System.out.println("Bot score is :"+countBot);
                    if(countBot>count)
                    {
                      ch=1;        
                      break;
                    }
                }
                    if(ch==1)
                    System.out.println("Score reached \n RESULTS ARE BELOW");
                System.out.println("Bot OUT! Bot's score is :"+countBot+"\n RESULTS ARE BELOW");
              }
            break;
            case 2:
            {
                while(User()!=Run())
                {
                    System.out.println("Bot chose :"+temp1);
                    countBot=countBot+temp1;
                    System.out.println(" Bot's score is :"+countBot);
                }
                System.out.println("Bot chose :"+temp1);
                System.out.println("Bot OUT! Bot's score is :"+countBot+" User's turn");
                System.out.println("------------------------");
                 while(User()!=Run())
                {
                    count=count+temp;
                    System.out.println("User score is :"+count);
                    if(countBot<count)
                    {
                        ch=1;
                    break;
                }
              }
                if(ch==1)
                System.out.println("Score reached \n RESULTS ARE BELOW");
                System.out.println("User OUT!Your score is :"+count+"\n RESULTS ARE BELOW");
            
          }
            break;
            default:
            System.out.println("INVALID INPUT");
        }
        System.out.println("User's score:\t Bot's score:");
        System.out.println(count+"\t \t"+countBot);
        if(count>countBot)
        System.out.println("User won by "+(count-countBot)+" runs");
        else if(count==countBot)
        System.out.println("DRAW");
        else
        System.out.println("Bot won by "+(countBot-count)+" runs");
        System.out.println("-------------------------------");
        
    }
}
                    
       
        
        
        
