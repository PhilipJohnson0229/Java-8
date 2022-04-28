import java.util.Scanner;
//Ungraded Practice Exercise
//page 27 in the textbook
//Philip Johnson
//Monday, Jan. 10, 2022
//explore jgrasp

public class UGPA
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      //print will allow you to submit your anser on the same line
      System.out.print("Please enter the weight grams of your Granny Smith: ");
      
      double weight = sc.nextDouble();
      
      final double PERCENTAGE = 0.27;
      
      double calculatedValue = PERCENTAGE * (weight / 100);
      
      //println will take up the entire line and your answer will be accepted on the next line
      System.out.println("Grms of protein in your Granny Smith: " + calculatedValue + "g");
   }
}