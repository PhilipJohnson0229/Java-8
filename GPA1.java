import java.util.Scanner;
//GPA1
//Philip Johnson
//Monday, Jan. 16, 2022
//Calculate grams of protein per 100g of Granny Smith apple

public class GPA1
{
     public static void main(String[] args)
   {
      final double PERCENTAGE = 0.05;
   
      Scanner sc = new Scanner(System.in);
      
      System.out.println("1. East Coast Region ");
      System.out.println("2. West Coast Region ");
      System.out.println("3. North Region ");
      System.out.println("4. South Region ");
      System.out.println("");
      
      System.out.print("Please enter your region from the choices displayed above: ");
      
      int choice = sc.nextInt();
      
      int amount = 0;
      String chosenRegioin = "";
      double calculatedValue = 0;
            
      switch(choice)
      {
         case 1:
            chosenRegioin = "East Coast Region";
            System.out.print("Please enter your sales for the " + chosenRegioin + " in millions: ");
            amount = sc.nextInt();
            
            calculatedValue = PERCENTAGE * (amount * 1000000.0);

            System.out.print("Your bonus for the " + chosenRegioin + " is $" + calculatedValue);
            break;
         
         case 2:
            chosenRegioin = "West Coast Region";
            System.out.print("Please enter your sales for the " + chosenRegioin + " in millions: ");
            amount = sc.nextInt();
            
            calculatedValue = PERCENTAGE * (amount * 1000000.0);
            
            System.out.print("Your bonus for the " + chosenRegioin + " is $" + calculatedValue);
            break;
         
         case 3: 
            chosenRegioin = "North Region";
            System.out.print("Please enter your sales for the " + chosenRegioin + " in millions: ");
            amount = sc.nextInt();
            
            calculatedValue = PERCENTAGE * (amount * 1000000.0);
            
            System.out.print("Your bonus for the " + chosenRegioin + " is $" + calculatedValue);
            break;
         
         case 4:
            chosenRegioin = "South Region";
            System.out.print("Please enter your sales for the " + chosenRegioin + " in millions: ");
            amount = sc.nextInt();
            
            calculatedValue = PERCENTAGE * (amount * 1000000.0);
            
            System.out.print("Your bonus for the " + chosenRegioin + " is $" + calculatedValue);
            break;
         
         default:
            chosenRegioin = "not recognized";
            System.out.print("Sorry, that region is " + chosenRegioin);

            break;
         
      }
   }
}