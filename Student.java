import java.util.Scanner;
//simple.java
//page 27 in the textbook
//Philip Johnson
//Monday, Jan. 10, 2022
//explore jgrasp

public class Student extends Animal
{
   private String color;
   
   public Student(String _name, int _age, String _mood, String _sound, String _color)
   {
      super(_name, _age, _mood, _sound);
      this.color = _color;  
   }
   
   public void MakeSound()
   {
      System.out.println("This is a " + name + " and for this test it makes a " + sound + " sound.");
      System.out.println("It is " + age + " years old and it's mood is " + mood + " and the favorite color is " + color);
   }

}