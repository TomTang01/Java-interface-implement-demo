///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Animal.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;

/**
 * A superclass that holds some data fields and methods for general animals
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Animal 
{
    private int age;
    private int health;
    private int strength;
    
    /**
     * no-arg constructor
     */
    public Animal()
    {
        age = 0;
        health = 0;
        strength = 0;
    }

    /**
     * custom constructor
     */
    public Animal(int age, int health, int strength)
    {
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    /**
     * accessor method for the variable age
     *
     * @return (age)
     */
    public int getAge()
    {
        return age;
    }

    /**
     * accessor method for the variable health
     *
     * @return (health)
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * accessor method for the variable strength
     *
     * @return (strength)
     */
    public int getStrength()
    {
        return strength;
    }

    /**
     * mutator method for the variable health
     *
     * @param (int health) (the new health to assign to the animal)
     * 
     * @return (void)
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * mutator method for the variable strength
     *
     * @param (int strength) (the new strength to assign to the animal)
     * 
     * @return (void)
     */
    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    /**
     * checks if the current object and the input animal are of the same class
     *
     * @param (Animal animal) (the input animal)
     * 
     * @return (true if they are of the same class, false otherwise)
     */
    public boolean sameSpecies(Animal animal)
    {
        return this.getClass() == animal.getClass();
    }

    /**
     * generates a random integer from 1 to the animal's strength (inclusive)
     * decrease the health of the input animal by that amount, 
     * then return the integer
     *
     * @param (Animal animal) (input animal)
     *
     * @return (the amount of damage done)
     */
    public int attack(Animal animal)
    {
        int atk = (int)(Math.random() * strength) + 1;
        animal.setHealth(animal.getHealth() - atk);
        return atk;
    }

    /**
     * Overrides the toString method in the String class
     *
     * @return (the string representation of the Animal object)
     */
    @Override
    public String toString() 
    {
        return "(" + getClass().getName() + ")" + " age: " + getAge() +
                "; health: " + getHealth() + "; strength: " + getStrength();
    }

    /**
     * method to be overrided by subclasses
     *
     * @return (void)
     */
    public void sleep()
    {
    }
}
