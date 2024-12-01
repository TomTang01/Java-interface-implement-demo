///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Tiger.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass of Animal that holds some data fields and methods for a tiger
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Tiger extends Animal
    implements Carnivore
{
    /**
     * no-arg constructor
     */
    public Tiger()
    {
    }

    /**
     * custom constructor
     */
    public Tiger(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Tiger sleeps, it gains 15 strength
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
     * When a Tiger eats an animal, it gains a third of the animal's strength
     *
     * @param (Animal animal) (the animal eaten)
     *
     * @return (void)
     */
    @Override
    public void eatAnimal(Animal animal)
    {
        setStrength(getStrength() + animal.getStrength() / 3);
    }
}
