// GPA5.java 
// Philip Johnson 
// 03/13/22 
// Log apple shipments and calculate average weights (modularized) 
 
import java.util.Scanner; 
import java.io.*; 
import java.util.ArrayList; 
 
import edu.fscj.cop2551c.AppleShipment; 

interface AppleShipmentManager 
{
   public void addShipment(AppleShipment shipment);
   public void showShipments();
   public ArrayList<AppleShipment> find(String typeSubstr);
}

//assignment 10
class EmptySearchList extends RuntimeException {
    public EmptySearchList(String msg)
    {
      super(msg);
    }
}

public class Logger implements AppleShipmentManager{ 
 
    // max shipments allowed 
    static final int MAX_SHIPMENTS = 4; 
     
    // array field to store shipments 
    private AppleShipment shipments[]; 
     
    // number of active shipments 
    private int shipmentCount; 
     
    public Logger() { 
        shipments = new AppleShipment[MAX_SHIPMENTS]; 
        // number of active shipments 
        shipmentCount = 0; 
    } 
         
    public static void main(String[] args) throws IOException { 
     
        Logger logger = new Logger(); 
      
        // variables for quantity and weight 
        int quantity = 0; 
        double weight = 0.0; 
         
        // menu selections 
        int menuChoice = 0; 
        Scanner input = new Scanner(System.in); 
        String wantsToContinue = "y"; 
                 
        // accumulator 
        double totalWeight = 0.0; 
         
        // output file 
        PrintWriter outFile = new PrintWriter("apples.txt"); 
         
       // apple shipment object to store selection 
 
        AppleShipment shipment = new AppleShipment(AppleShipment.APPLE_UNKNOWN);                
 
        // prompt the user for apple information until they are done 
        while (wantsToContinue.equalsIgnoreCase("y")) {         
 
            menuChoice = getMenuChoice(input); 
             
            // set apple type based on menu choice 
            switch (menuChoice) { 
                case 1:  
                     shipment = new AppleShipment(AppleShipment.APPLE1); 
                     break; 
                case 2:  
                     shipment = new AppleShipment(AppleShipment.APPLE2); 
                     break; 
                case 3:  
                     shipment = new AppleShipment(AppleShipment.APPLE3); 
                     break; 
                case 4:  
                     shipment = new AppleShipment(AppleShipment.APPLE4); 
                     break; 
            } 
             
            // check for duplicate and reject if found 
            if (logger.foundDuplicate(shipment) == true) { 
                System.out.println("duplicate shipment found in current data, please try again"); 
                continue; 
            } 
             
            if (shipment == null) 
                System.out.println("Sorry, that is not a known apple type."); 
            else { 
                quantity = inputQuantity(input, shipment.getAppleType()); 
                shipment.setQuantity(quantity); 
                 
                weight = inputWeight(input, shipment.getAppleType()); 
                shipment.setTotalWeight(weight); 
                 
                shipment.calcAndShowAverage(); 
                outFile.printf("%-20s %-4d %-4.2f\n",  
                    shipment.getAppleType(), quantity, weight);     
                     
                totalWeight += weight; // add weight to accumulator 
                logger.addShipment(shipment); // save shipment data 
            } 
            System.out.print("Would you like to log more apples? (y/n): "); 
             
            // flush the keyboard buffer, then read the next line 
            input.nextLine(); 
            wantsToContinue = input.nextLine(); 
        } 
        System.out.printf("Your total shipment weighs %.2f lbs.\n", totalWeight); 
        logger.showShipments(); // show all the shipments 
        outFile.close(); 
         
        // search for a shipment based on type (substring) 
        System.out.print("Would you like to search the data? (y/n): "); 
        String search = input.nextLine(); 
        if (search.equalsIgnoreCase("y")) { 
            System.out.print("Enter a search phrase for the apple type name: "); 
            search = input.nextLine(); 
             
            // find will throw an EmptySearchList exception if no matches found
            try 
            {
               ArrayList<AppleShipment> foundList = logger.find(search);
               System.out.println("Found the following matches:");
                  for (AppleShipment type : foundList)
                     System.out.println(type);
            } 
            catch (EmptySearchList em) 
            {
               System.out.println(em);
            }

            
            // find will return null if no matches found 
            ArrayList<AppleShipment> foundList = logger.find(search); 
            if (foundList != null) { 
                System.out.println("Found the following matches:");     
                for (AppleShipment ship : foundList) 
                    System.out.println(ship); 
            } else 
                System.out.println("Did not find a match."); 
        }         
    } 
     
    public void addShipment(AppleShipment shipment) { 
        shipments[shipmentCount++] = shipment; 
    } 
     
    public void showShipments() { 
        for (int i = 0; i < shipmentCount; i++) 
            System.out.println(shipments[i]); 
    } 
     
    // search for apple type with matching prefix 
    // return ArrayList of matches, or null if none found. 
    // Use copy constructor for ArrayList objects 
    public ArrayList<AppleShipment> find(String typeSubstr) throws EmptySearchList { 
        ArrayList<AppleShipment> retList = null; 
  
        // convert the search pattern to lower case for comparison 
        typeSubstr = typeSubstr.toLowerCase(); 
        for (AppleShipment ship : shipments) { 
            if (ship != null) { 
                // convert the shipment type for this shipment to lower case 
                String typeStr = ship.getAppleType().toLowerCase(); 
                 
                // indexOf returns -1 if substring is not found 
                if (typeStr.indexOf(typeSubstr) >= 0) { 
                    // if this is our first match, create the array list 
                    if (retList == null) 
                        retList = new ArrayList<AppleShipment>(); 
                    // use copy constructor for added object 
                    retList.add(new AppleShipment(ship)); 
                } 
            } 
        } 
        
        // throw a new exception if no matches found
       if (retList == null)
       {
         throw new EmptySearchList("Exception: No match found for \"" + typeSubstr + "\"");
       }
       

        return retList; 
    } 
     
    // loop through array and check for duplicates 
    public boolean foundDuplicate(AppleShipment a) { 
        boolean foundDup = false; // default 
        for (int i = 0; i < shipmentCount && foundDup == false; i++) 
            if (a.equals(shipments[i])) 
                foundDup = true; 
        return foundDup; 
    }  
      
    // get and validate menu choice 
    public static int getMenuChoice(Scanner input) { 
     
        int menuChoice = 0; 
     
        do { // nested loop 
         
            // display menu 
            System.out.println(1 + ". " + AppleShipment.APPLE1); 
            System.out.println(2 + ". " + AppleShipment.APPLE2); 
            System.out.println(3 + ". " + AppleShipment.APPLE3); 
            System.out.println(4 + ". " + AppleShipment.APPLE4);   
            System.out.print( 
                    "Please enter the apple type from the choices displayed above: "); 
            //assignment 10
            try 
            {
               menuChoice = input.nextInt();
               if (menuChoice < 1 || menuChoice > AppleShipment.NUM_TYPES)
                  System.out.println("Sorry, that is an invalid choice.");
            } 
            catch (java.util.InputMismatchException e) 
            {
                System.out.println("Sorry, that is an invalid choice.");
                // flush the keyboard buffer
                input.nextLine();
            }
                           
        } while (menuChoice < 1 || menuChoice > AppleShipment.NUM_TYPES); 
         
        return menuChoice; 
    } 
     
    // get and validate quantity // renamed to avoid confusion with AppleShipment getter 
    public static int inputQuantity(Scanner input, String type) { 
        int qty = 0; 
        String prompt = String.format( 
            "Please enter the quantity of %s apples received [1 - %d]: ",  
            type, AppleShipment.MAX_QTY);       
        do { 
             
            //assignment 10
            try 
            {
               System.out.print(prompt); 
               qty = input.nextInt();
            }
            catch (java.util.InputMismatchException e) {
               System.out.println("Sorry, that is an invalid value.");
               // flush the keyboard buffer
               input.nextLine();
             }

            
            if (qty < 1 || qty >  AppleShipment.MAX_QTY) 
                System.out.println("Sorry, that is not a valid quantity"); 
        } while (qty < 1 || qty >  AppleShipment.MAX_QTY); 
         
        return qty; 
    } 
     
    // get and validate weight // renamed to avoid confusion with AppleShipment getter 
    public static double inputWeight(Scanner input, String type) { 
        double weight = 0; 
        String prompt = String.format( 
            "Please enter the total weight of the %s apples, in lbs. [1.0 - %.1f]: ", 
                type,  AppleShipment.MAX_WEIGHT);     
        do { 
            System.out.print(prompt); 
            weight = input.nextDouble(); 
            if (weight < 1 || weight >  AppleShipment.MAX_WEIGHT) 
                System.out.println("Sorry, that is not a valid weight"); 
        } while (weight < 1.0 || weight >  AppleShipment.MAX_WEIGHT); 
         
        return weight; 
    } 
    
    
}


