import java.util.Scanner;
//simple.java
//page 27 in the textbook
//Philip Johnson
//Monday, Jan. 10, 2022
//explore jgrasp

public class Animal 
{
   public String name;
   public int age;
   public String mood;
   public String sound;
   
   public Animal(String _name, int _age, String _mood, String _sound)
   {
      name = _name;
      age = _age;
      mood = _mood;
      sound = _sound;
   }
   
   
   public void MakeSound()
   {
      System.out.println("This is a " + name + " and for this test it makes a " + sound + " sound.");
      System.out.println("It is " + age + " years old and it's mood is " + mood);
   }
}