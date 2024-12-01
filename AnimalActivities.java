///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment8.java
// Files:              AnimalActivities.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * 2 activities animals will do in the game:
 * fight() and reproduce()
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class AnimalActivities 
{
    // Necessary constants
    private final static int NUM_ANIMALS = 6;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";

    /**
     * no-arg constructor
     */
    public AnimalActivities()
    {}

    /**
     * 2 animals fight, resulting in 1 win 1 loss or a tie
     *
     * @param (Animal animal1) (the first animal)
     * @param (Animal animal2) (the second animal)
     * @return (0 if ties,1 if animal1 wins, 2 if animal2 wins)
     */
    public static int fight(Animal animal1, Animal animal2)
    {
        boolean ani1IsPoisoned = false;
        boolean ani2IsPoisoned = false;
        int roundNum = 1;
        if(animal1 instanceof Poisonous)
        {
            ani2IsPoisoned = ((Poisonous)animal1).poisonAnimal();
        }
        if(animal2 instanceof Poisonous)
        {
            ani1IsPoisoned = ((Poisonous)animal2).poisonAnimal();
        }
        while(animal1.getHealth()>0 && animal2.getHealth()>0)
        {
            printRound(roundNum);
            printBothAnimals(animal1, animal2);
            printAttack(LEFT, animal1.attack(animal2));
            printAttack(RIGHT, animal2.attack(animal1));
            ++roundNum;
        }
        printFinalStats(animal1, animal2, ani1IsPoisoned || ani2IsPoisoned);
        if(animal1.getHealth()<0 && animal2.getHealth()<0)
        {
            printTieGame();
            return 0;
        }
        else if(animal1.getHealth()>0)
        {
            if(ani1IsPoisoned)
            {
                printTieGame();
                return 0;
            }
            if(animal1 instanceof Carnivore)
            {
                ((Carnivore)animal1).eatAnimal(animal2);
            }
            else
            {
                ((Herbivore)animal1).eatPlant();
            }
            printWinner(LEFT);
            return 1;
        }
        else
        {
            if(ani2IsPoisoned)
            {
                printTieGame();
                return 0;
            }
            if(animal2 instanceof Carnivore)
            {
                ((Carnivore)animal2).eatAnimal(animal2);
            }
            else
            {
                ((Herbivore)animal2).eatPlant();
            }
            printWinner(RIGHT);
            return 2;
        }
    }

    /**
     * Lets the two animals have a baby if conditions are met
     *
     * @param (Animal animal1) (the first animal)
     * @param (Animal animal2) (The second animal)
     * @return (the baby)
     */
    public static Animal reproduce(Animal animal1, Animal animal2)
    {
        if(animal1.sameSpecies(animal2) &&
            animal1.getAge() > 5 && animal2.getAge() > 5)
        {
            if(animal1 instanceof Lion)
            {
               return new Lion(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
            else if(animal1 instanceof Tiger)
            {
               return new Tiger(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
            else if(animal1 instanceof Elephant)
            {
               return new Elephant(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
            else if(animal1 instanceof Rhino)
            {
               return new Rhino(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
            else if(animal1 instanceof Snake)
            {
               return new Snake(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
            else if(animal1 instanceof Frog)
            {
               return new Frog(0, 100, (animal1.getStrength() + animal2.getStrength()) / 2); 
            }
        }
        return new Animal();
    }

    //Helper methods
    
    /**
    * Use this method in fight() to display the stats of both animals together
    *
    * @param (animal1) Animal on the left side to display stats
    * @param (animal2) Animal on the right side to display stats
    */
    public static void printBothAnimals(Animal animal1, Animal animal2) 
    {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(Integer.toString(animal1.getHealth()));
        int strSpacing = calcSpacing(Integer.toString(animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getClass().getName());
        String str = "(" + animal1.getClass().getName() + ")" +
        " ".repeat(animalSpacing) + "(" +
        animal2.getClass().getName() + ")\n" +
        "----------" + " " + "----------\n" +
        "A: " + animal1.getAge() + " ".repeat(ageSpacing) +
        "A: " + animal2.getAge() + "\n" +
        "H: " + animal1.getHealth() + " ".repeat(healthSpacing) +
        "H: " + animal2.getHealth() + "\n" +
        "S: " + animal1.getStrength() + " ".repeat(strSpacing) +
        "S: " + animal2.getStrength() + "\n";
        System.out.println(str);
    }

    /**
    * Helper method for printBothAnimals()
    *
    * @param (str) String on the left - used to calculate spacing
    * @return An int describing how many spaces to put between strings
    */
    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
            return 0;
        }
            return spacing;
    }

    /**
    * Use this method in fight() to display the current round.
    * @param (round) An int of the round (should start at 0)
    */
    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }

    /**
    * Use this method in fight() to display the damage each round.
    *
    * @param (side) The side of the Animal that invoked the attack().
    * @param (damage) The int (damage) returned from an attack() call
    */
    public static void printAttack(String side, int damage) {
        System.out.println(side + " does " + damage + " damage!");
    }

    /**
    * Use this method in fight() to display final stats and poison status.
    *
    * @param (animal1) Left animal
    * @param (animal2) Right animal
    * @param (poisoned) If either animal was poisoned
    */
    public static void printFinalStats(Animal animal1, Animal animal2,
        boolean poisoned) {
        System.out.println();
        printBothAnimals(animal1, animal2);
        if (poisoned) {
            System.out.println("An animal was poisoned.");
        }
    }

    /**
    * Use this method in fight() to display a tie game.
    */
    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both animals died!");
    }

    /**
    * Use this method in fight() to display the winner.
    * @param (side) The side of the Animal that won.
    */
    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " animal wins!");
    }
}

