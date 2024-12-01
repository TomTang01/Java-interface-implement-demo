///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Elephant.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;

/**
 * A subclass of Animal that holds some data fields and methods for a elephant
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Elephant extends Animal
    implements Herbivore
{
    /**
     * no-arg constructor
     */
    public Elephant()
    {
    }

    /**
     * custom constructor
     */
    public Elephant(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Elephant sleeps, it gains 10 strength
     *
     * @return (void)
     */
    @Override
    public void sleep()
    {
        setStrength(getStrength() + 10);
    }

    /**
     * Override eatPlant
     * When a Elephant eats plants, it randomly gains 0 ~ 40 strength
     *
     * @return (void)
     */
    @Override
    public void eatPlant()
    {
        setStrength(getStrength() + (int)(Math.random() * 41));
    }
}
