// M3GPA.java
// Philip Johnson
// 02/06/22
// Calculate average weight based on amounts of specific apple types

import java.util.Scanner;
import java.io.*; 

public class M3GPA {
    public static void main(String[] args) throws IOException {
    
        // constants for apple types
        final int NUM_TYPES = 4;
        final String GRANNY_SMITH = "Granny Smith";
        final String PAULLA_RED = "Paula Red";
        final String GOLDEN_DELICIOUS = "Golden Delicious";
        final String PINK_PEARL = "Pink Pearl";
        final String UNKNOWN = "Sorry, that is not a known apple type.";
                
        //intialize this string to UKNOWN at first     
        String appleType = UNKNOWN;
          
        int appleAmount;
        double appleWeight;
        double averageWeight;
                
        Scanner input = new Scanner(System.in);
        
          // output file 
        PrintWriter outFile = new PrintWriter("apples.txt");      
        // set apple type based on user selection
        int menuChoice = 0;
        
        String wantsToContinue = "y"; 
                 
        // accumulator 
        double totalWeight = 0.0; 
          
        // prompt the user for sales information until they are done 
        while (wantsToContinue.equalsIgnoreCase("y")) 
        {
            do
            {
                    // display menu
              System.out.println(1 + ". " + GRANNY_SMITH);
              System.out.println(2 + ". " + PAULLA_RED);
              System.out.println(3 + ". " + GOLDEN_DELICIOUS);
              System.out.println(4 + ". " + PINK_PEARL);  
              System.out.print(
                      "Please enter your apple type from the choices displayed above: ");
                      
              menuChoice = getMenuChoice(input); 
              
              if (menuChoice < 1 || menuChoice > NUM_TYPES)
              {
                  System.out.println("Sorry, that is an invalid choice.");
              }
                     
            
            }while(menuChoice < 1 || menuChoice > NUM_TYPES);  
            
            switch (menuChoice) {
               case 1: 
                    appleType = GRANNY_SMITH;
                    break;
               case 2: 
                    appleType = PAULLA_RED;
                    break;
               case 3: 
                    appleType = GOLDEN_DELICIOUS;
                    break;
               case 4: 
                    appleType = PINK_PEARL;
                    break;
               default:
                    appleType = UNKNOWN;
                    break;
            }
              
            if (appleType == UNKNOWN)
               System.out.print("Sorry, that is not a known apple type.");
            else 
            {
               //prompt user for amount of apple type and total weight of all apples
               System.out.printf("Please enter the quantity of " + appleType + " apples received: ");
               appleAmount = input.nextInt();
               System.out.printf("Please enter the total weight of the %s, in lbs.:", appleType);
               appleWeight = input.nextDouble();
            
               // calculate average weight
               averageWeight = appleWeight / appleAmount;   
               System.out.printf("The average weight of your %s is %.2f\n", 
                       appleType, averageWeight);  
                       
               outFile.printf("%-20s %.0flbs\n", appleType, appleWeight);   
               totalWeight += appleWeight; // add weight to accumulator     
            }
            
            System.out.print("Would you like to enter more sales data? (y/n): "); 
             
            // flush the keyboard buffer, then read the next line 
            input.nextLine(); 
            wantsToContinue = input.nextLine(); 
           } 
        
        System.out.printf("Total shipment weight is %.0flbs\n", totalWeight);
        outFile.close();  
       }   
       
         // get and validate menu choice 
    static int getMenuChoice(Scanner input) { 
 
        int menuChoice = 0; 
         
        do { // nested loop         
 
            // display menu 
            System.out.println(1 + ". " + REGION1); 
            System.out.println(2 + ". " + REGION2); 
            System.out.println(3 + ". " + REGION3); 
            System.out.println(4 + ". " + REGION4);   
            System.out.print( 
                    "Please enter your region from the choices displayed above: "); 
             
            menuChoice = input.nextInt(); 
            if (menuChoice < 1 || menuChoice > NUM_REGIONS) 
                System.out.println("Sorry, that is an invalid choice."); 
                     
        } while (menuChoice < 1 || menuChoice > NUM_REGIONS); 
         
        return menuChoice; 
    } 
     
    // calculate bonus and return. Return 0 if minimum sales not met. 
    static double calculateBonus(double userSales, double minSales) { 
        double bonusCalc = 0.0; 
         
        if (userSales >= minSales) 
            bonusCalc = userSales * BONUS * 1.0e06; 
             
        return bonusCalc; 
    } 
     
    // show the calculated bonus 
    static void displayBonus(double bonus, String region) { 
        if (bonus > 0.0)  
            System.out.printf("Your bonus for the %s is $%.2f\n", region, bonus); 
        else 
            System.out.println("Sorry, your sales did not meet the minimum for the " + region); 
      }               
}
        
        