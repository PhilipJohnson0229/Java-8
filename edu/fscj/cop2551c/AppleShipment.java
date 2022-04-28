//AppleShipments.java
//Philip Johnson
//03/13/2022
//class that stores member fields for apple shipments for use of instanced objects

package edu.fscj.cop2551c; 
 
public class AppleShipment { 
 
    // class constants for max quantity and weight 
    public static final int MAX_QTY = 200; 
    public static final double MAX_WEIGHT = 400.0; 
     
    // class constants for apple types 
    public static final int NUM_TYPES = 4; 
    public static final String APPLE1 = "Granny Smith"; 
    public static final String APPLE2 = "Paula Red"; 
    public static final String APPLE3 = "Golden Delicious"; 
    public static final String APPLE4 = "Pink Pearl"; 
    public static final String APPLE_UNKNOWN = "Unknown Apple Type";     
     
    private String appleType; 
    private int quantity; 
    private double totalWeight; 
     
    // constructors 
    // default 
    public AppleShipment() { 
        appleType = "Unknown Type"; 
        quantity = 0; 
        totalWeight = 0.0; 
    }     
     
    // overload for appleType 
    public AppleShipment(String appleType) { 
        this.appleType = appleType; 
        quantity = 0; 
        totalWeight = 0.0; 
    } 
     
    // copy constructor 
    public AppleShipment(AppleShipment sh) { 
        // create new object 
        this(sh.appleType); 
        // overload does not set quantity or weight 
        this.setQuantity(sh.quantity); 
        this.setTotalWeight(sh.totalWeight);         
    }     
     
    // accessors 
    public String getAppleType() { 
        return appleType; 
    } 
     
    public int getQuantity() { 
        return quantity; 
    } 
     
    public double getTotalWeight() { 
        return totalWeight; 
    } 
     
    // mutators  
    public void setAppleType(String appleType) { 
        this.appleType = appleType; 
    } 
     
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    } 
     
    public void setTotalWeight(double totalWeight) { 
        this.totalWeight = totalWeight; 
    } 
     
    // calculate and show the average weight 
    public  void calcAndShowAverage() { 
        double average = getTotalWeight() / getQuantity(); 
        System.out.printf("The average weight of your %s apples is %.2f lbs.\n", 
                    getAppleType(), average); 
    } 
     
    public String toString() { 
        return "Type: " + getAppleType() + 
               " Weight " + getTotalWeight() + " lbs." + 
               " Quantity: " + getQuantity(); 
    } 
     
    // compare appleType to determine if the parameter is equal  
    @Override
    public boolean equals(Object o) { 
        boolean isEqual = false; 
        if (o instanceof AppleShipment)
        {
            AppleShipment r = (AppleShipment)o;
            if (appleType.equals(r.appleType)) 
            isEqual = true;
        }
        else
        {
            isEqual = false;
        }
         
         
        return isEqual; 
    } 
}