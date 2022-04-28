import java.util.Scanner;
//simple.java
//page 27 in the textbook
//Philip Johnson
//Monday, Jan. 10, 2022
//explore jgrasp

public class Zoo
{
   private Elephant elephant;
       
   //default constructor
   public Zoo()
   {
      elephant = new Elephant();
   }
    
   //overloaded constructor
   public Zoo(Elephant theElephant)
   {
      elephant = theElephant;
   }
   
   //Accessor
   public Elephant GetElephant()
   {
      return elephant;
   }
   
   //Mutator
   public SetElephant(Elephant newElephant)
   {
      elephant = newElephant;
   }
}