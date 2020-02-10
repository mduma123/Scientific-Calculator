import java.util.Scanner;

public class Btest {

    public static void main(String[] args) {
        Validate validate = new Validate();
        Rpn rpn = new Rpn();
        //DoCalc calc = new DoCalc(); BASIC ONLY
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext())
        {
            String str= scan.next();
            if(str.equals("q"))
            {
                scan.close();
                break ;
            }
            if(validate.Check(str))
            {
                System.out.println(rpn.preCalc(str));
            }
            else
                System.out.println("Invalid Input");
            System.out.println("----------------------");
        }
        System.out.println("Terminating Btest");
    }
}