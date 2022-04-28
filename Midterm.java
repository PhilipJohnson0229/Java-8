import java.util.Scanner;
//GPA1
//Philip Johnson
//Monday, Jan. 16, 2022
//Calculate grams of protein per 100g of Granny Smith apple

public class Midterm
{
    public static void main(String[] args)
   {
      int[] idNums = {5000, 5001, 5002, 5003, 5004, 5006};
      double[] weeklyGrossPay = {33000.00, 43000.75, 28750.50, 31050.00, 36825.00};
      
      DisplayData(idNums, weeklyGrossPay);
   }
   
   public static void DisplayData(int[] identification, double[] grossPay)
   {
      for (int i = 0; i < identification.length - 1; i++)
      {
         System.out.print("ID Number: " + identification[i] + "     ");
         System.out.println("Gross Pay: $" + grossPay[i]);
      }
   }
}

  