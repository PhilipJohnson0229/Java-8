// GPA5.java 
// Philip Johnson 
// 02/20/22 
// Log apple shipments and calculate average weights (modularized) 
 
import java.util.Scanner; 
import java.io.*; 

import edu.fscj.cop2551c.AppleShipment; 

public class GPA5 { 
 
    // class constants for max quantity and weight 
    static final int MAX_QTY = 200; 
    static final double MAX_WEIGHT = 400.0; 
     
    // class constants for apple types 
    static final int NUM_TYPES = 4; 
    static final String APPLE1 = "Granny Smith"; 
    static final String APPLE2 = "Paula Red"; 
    static final String APPLE3 = "Golden Delicious"; 
    static final String APPLE4 = "Pink Pearl"; 
    static final String APPLE_UNKNOWN = "Unknown Apple Type"; 
     
   
         
    public static void main(String[] args) throws IOException { 
      
        // variables for quantity, weight, average, and apple type 
        int quantity = 0; 
        double weight = 0.0; 
        double average = 0.0; 
         
        // menu selections 
        //String appleType = APPLE_UNKNOWN; 
        int menuChoice = 0; 
        Scanner input = new Scanner(System.in); 
        String wantsToContinue = "y"; 
                 
        // accumulator 
        double totalWeight = 0.0; 
         
        // output file 
        PrintWriter outFile = new PrintWriter("apples.txt"); 
         
        //creating a reference variable for the AppleShipment instanced object
        AppleShipment aShipment = new AppleShipment(APPLE_UNKNOWN);
        
        // prompt the user for apple information until they are done 
        while (wantsToContinue.equalsIgnoreCase("y")) {         
 
            menuChoice = getMenuChoice(input); 
             
            // set apple type based on menu choice 
            switch (menuChoice) { 
                case 1:  
                     aShipment = new AppleShipment(APPLE1);
                     break; 
                case 2:  
                     aShipment = new AppleShipment(APPLE2);
                     break; 
                case 3:  
                     aShipment = new AppleShipment(APPLE3);                 
                     break; 
                case 4: 
                     aShipment = new AppleShipment(APPLE4);
                     break; 
                default: 
                     aShipment = new AppleShipment(APPLE_UNKNOWN);
                     break; 
            } 
             
            if (aShipment.GetType() == APPLE_UNKNOWN) 
                System.out.println("Sorry, that is not a known apple type."); 
            else { 
                //receive input for quantity and weight and then pass those values to the setter functions of the AppleSipment instance
                quantity = receiveQuantity(input, aShipment.GetType()); 
                aShipment.SetQuantity(quantity);

                weight = receiveWeight(input, aShipment.GetType());
                aShipment.SetWeight(weight);
 
                aShipment.calcAndShowAverage(); 
                outFile.printf("%-20s %-4d %-4.2f\n", aShipment.GetType(), quantity, weight);     
                     
                totalWeight += weight; // add weight to accumulator 
            } 
            System.out.print("Would you like to log more apples? (y/n): "); 
             
            // flush the keyboard buffer, then read the next line 
            input.nextLine(); 
            wantsToContinue = input.nextLine(); 
        } 
        System.out.printf("Your total shipment weighs %.2f lbs.\n", totalWeight); 
        outFile.close(); 
    } 
         
    // get and validate menu choice 
    static int getMenuChoice(Scanner input) { 
     
        int menuChoice = 0; 
     
        do { // nested loop 
         
            // display menu 
            System.out.println(1 + ". " + APPLE1); 
            System.out.println(2 + ". " + APPLE2); 
            System.out.println(3 + ". " + APPLE3); 
            System.out.println(4 + ". " + APPLE4);   
            System.out.print("Please enter the apple type from the choices displayed above: "); 
     
            menuChoice = input.nextInt(); 
            if (menuChoice < 1 || menuChoice > NUM_TYPES) 
                System.out.println("Sorry, that is an invalid choice."); 
                 
        } while (menuChoice < 1 || menuChoice > NUM_TYPES); 
         
        return menuChoice; 
    } 
     
    // get and validate quantity 
    public static int receiveQuantity(Scanner input, String type) { 
        int qty = 0; 
        String prompt = String.format( 
            "Please enter the quantity of %s apples received [1 - %d]: ", type, MAX_QTY);       
        do { 
            System.out.print(prompt); 
            qty = input.nextInt();                  
                       
            if (qty < 1 || qty > MAX_QTY) 
                System.out.println("Sorry, that is not a valid quantity"); 
        } while (qty < 1 || qty > MAX_QTY); 


        return qty; 
    } 
     
    // get and validate weight 
    public static double receiveWeight(Scanner input, String type) { 
        double weight = 0; 
        String prompt = String.format( "Please enter the total weight of the %s apples, in lbs. [1.0 - %.1f]: ", type, MAX_WEIGHT);          
        do { 
            System.out.print(prompt); 
            weight = input.nextDouble(); 
                            
            if (weight < 1 || weight > MAX_WEIGHT) 
                System.out.println("Sorry, that is not a valid weight"); 
        } while (weight < 1.0 || weight > MAX_WEIGHT); 
         
        return weight; 
    } 
} 