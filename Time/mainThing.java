import java.util.Scanner;

class mainThing
{
    public mainThing()
    {
        Time time = new Time();
        Scanner in = new Scanner(System.in);

        boolean done = false;
        while (!done)
        {
            int choice = 0;
            System.out.println ("0 = quit, 1 = modify time, 2 = add, 3 = subtract, 4 = check equality)");
            System.out.print ("your choice? ");
            choice = Integer.valueOf(in.nextLine()).intValue();

            if(choice==0)
            {
                done = true; 
                System.out.println ("Exited.  Game over, thank you for playing");
            }

            else if (choice==1)
            {
                int h, m, s;
                System.out.print ("new hour value? ");
                h  = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("new minute value? ");
                m  = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("new second value? ");
                s  = Integer.valueOf(in.nextLine()).intValue();
                time.setHour(h);
                time.setMinute(m);
                time.setSecond(s);
            }  // choice 1
            else if (choice==2)
            {

                System.out.println("Input the second time to add to the first. ");
                int b1, b2, b3;
                System.out.print ("Hours: ");
                b1 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Minutes: ");
                b2 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Seconds: ");
                b3 = Integer.valueOf(in.nextLine()).intValue();
                Time B = new Time(b1,b2,b3);
                System.out.println("The second time is: " + B);
                System.out.println();
                System.out.print (time + " + ");
                time.addition(B);
                time.reduce();
                System.out.println (B + " = " + time);

            }//end choice == 2

            else if (choice==3)
            {
                System.out.println("Input the second time to subtract from the first. ");
                int b1, b2, b3;
                System.out.print ("Hours: ");
                b1 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Minutes: ");
                b2 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Seconds: ");
                b3 = Integer.valueOf(in.nextLine()).intValue();
                Time B = new Time(b1,b2,b3);
                System.out.println("The second time is: " + B);
                System.out.println();
                System.out.print (time + " - ");
                time.subtract(B);
                time.reduce();
                System.out.println (B + " = " + time);

            }//end choice == 3
            //other stuff not shown, either...
			
			else if(choice == 4) {
				System.out.println("Input the second time to check equality from the first. ");
                int b1, b2, b3;
                System.out.print ("Hours: ");
                b1 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Minutes: ");
                b2 = Integer.valueOf(in.nextLine()).intValue();
                System.out.print ("Seconds: ");
                b3 = Integer.valueOf(in.nextLine()).intValue();
                Time B = new Time(b1,b2,b3);
                System.out.println(time + " == " + B + " == " + time.equals(B));
			}
        } //end while
    }

    public static void main (String [] args)
    {
        new mainThing();
    }
}