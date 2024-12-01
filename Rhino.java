///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Rhino.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;

/**
 * A subclass of Animal that holds some data fields and methods for a rhino
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Rhino extends Animal
    implements Herbivore
{
    /**
     * no-arg constructor
     */
    public Rhino()
    {
    }

    /**
     * custom constructor
     */
    public Rhino(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Rhino sleeps, it gains 15 strength
     *
     * @return (void)
     */
    @Override
    public void sleep()
    {
        setStrength(getStrength() + 15);
    }

    /**
     * Override eatPlant
     * When a Rhino eats plants, it randomly gains 0 ~ 25 strength
     *
     * @return (void)
     */
    @Override
    public void eatPlant()
    {
        setStrength(getStrength() + (int)(Math.random() * 26));
    }
}
