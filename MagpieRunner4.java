import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner4
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        Magpie4 maggie = new Magpie4();

        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        System.out.println("Insert value for r:");
        double r = Double.parseDouble(in.nextLine());
        System.out.println("Insert value for angle:");
        double o = Double.parseDouble(in.nextLine());
        System.out.println("Insert value for coefficient of friction");
        double u = Double.parseDouble(in.nextLine());
        String statement = in.nextLine();
        in.close();

        double v = (Math.sqrt((r * 9.8 * Math.sin(o)) + (r * 9.8 * u * Math.cos(o)) / (Math.cos(o) - u * Math.sin(o))));

        if (Double.isNaN(v))
        {
            System.out.println("Impossible");
        } else System.out.println("The maximum safe velocity is: " + v);

		
        //while (!statement.equals("Terminate"))
        //{
         //   System.out.println (maggie.getResponse(statement));
         //   statement = in.nextLine();
       // }
    }
}
