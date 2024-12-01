///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              Lion.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A subclass of Animal that holds some data fields and methods for a lion
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Lion extends Animal
    implements Carnivore
{
    /**
     * no-arg constructor
     */
    public Lion()
    {
    }

    /**
     * custom constructor
     */
    public Lion(int age, int health, int strength)
    {
        super(age, health, strength);
    }

    /**
     * Override sleep
     * When a Lion sleeps, it gains 20 strength
     *
     * @return (void)
     */
    @Override
    public void sleep()
    {
        setStrength(getStrength() + 20);
    }

    /**
     * Override eatAnimal
     * When a Lion eats an animal, it gains half of the animal's strength
     *
     * @param (Animal animal) (the animal eaten)
     *
     * @return (void)
     */
    @Override
    public void eatAnimal(Animal animal)
    {
        setStrength(getStrength() + animal.getStrength() / 2);
    }
}
