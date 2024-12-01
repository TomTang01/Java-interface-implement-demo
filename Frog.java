///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Frog.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass of Animal that holds some data fields and methods for a frog
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Frog extends Animal
    implements Carnivore, Poisonous
{
    /**
     * no-arg constructor
     */
    public Frog()
    {
    }

    /**
     * custom constructor
     */
    public Frog(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Frog sleeps, it gains 10 strength
     *
     * @return (void)
     */
    @Override
    public void sleep()
    {
        setStrength(getStrength() + 10);
    }

    /**
     * Override eatAnimal
     * When a Frog defeats an animal, it eats a bug attacted to 
     * the animal's carcass, which gives it 1/4 of the animal's strength
     *
     * @param (Animal animal) (the animal defeated)
     *
     * @return (void)
     */
    @Override
    public void eatAnimal(Animal animal)
    {
        setStrength(getStrength() + animal.getStrength() / 4);
    }

    /**
     * Override poisonAnimal
     * A Frog has a 20% chance to poison the other animal.
     *
     * @return (whether the animal is poisoned)
     */
    public boolean poisonAnimal()
    {
        return Math.random() < 0.2;
    }
}
