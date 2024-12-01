///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Snake.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;

/**
 * A subclass of Animal that holds some data fields and methods for a snake
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Snake extends Animal
    implements Carnivore, Poisonous
{
    /**
     * no-arg constructor
     */
    public Snake()
    {
    }

    /**
     * custom constructor
     */
    public Snake(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Snake sleeps, it gains 15 strength
     *
     * @return (void)
     */
    @Override
    public void sleep()
    {
        setStrength(getStrength() + 15);
    }

    /**
     * Override eatAnimal
     * When a Snake eats an animal, it gains all of the animal's strength
     *
     * @param (Animal animal) (the animal eaten)
     *
     * @return (void)
     */
    @Override
    public void eatAnimal(Animal animal)
    {
        setStrength(getStrength() + animal.getStrength());
    }

    /**
     * Override poisonAnimal
     * A Snake has a 40% chance to poison the other animal.
     *
     * @return (whether the animal is poisoned)
     */
    public boolean poisonAnimal()
    {
        return Math.random() < 0.4;
    }
}
