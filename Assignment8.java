///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment8
// Files:              None
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

/**
 * The main class for this assignment, 
 * used to test all of the methods in all other classes
 *
 * Bugs: None
 *
 * @author Tom Tang
 */
public class Assignment8
{
    /**
     * the main method, where all the unit tests are tested
     * 
     * @return (void)
     */
    public static void main(String args[])
    {
        if(!unitTest1())
        {
            System.out.println("Test1 Failed.");
        }
        else if(!unitTest2())
        {
            System.out.println("Test2 Failed.");
        }
        else if(!unitTest3())
        {
            System.out.println("Test3 Failed.");
        }
        else if(!unitTest4())
        {
            System.out.println("Test4 Failed.");
        }
        else if(!unitTest5())
        {
            System.out.println("Test5 Failed.");
        }
        else 
        {
            System.out.println("All unit tests passed.");
        }
    }

    /**
     * test for sleep
     *
     * @return (true if passed, false if not)
     */
    public static boolean unitTest1()
    {
        Tiger tiger = new Tiger(7, 500, 250);
        Lion lion = new Lion(7, 650, 300);
        Rhino rhino = new Rhino(7, 650, 200);
        Elephant elephant = new Elephant(7, 700, 150);
        Snake snake = new Snake(7, 200, 150);
        Frog frog = new Frog(3, 85, 20);
        tiger.sleep();
        lion.sleep();
        rhino.sleep();
        elephant.sleep();
        snake.sleep();
        frog.sleep();
        if(tiger.getStrength() != 265) return false;
        if(lion.getStrength() != 320) return false;
        if(rhino.getStrength() != 215) return false;
        if(elephant.getStrength() != 160) return false;
        if(snake.getStrength() != 165) return false;
        if(frog.getStrength() != 30) return false;

        return true;
    }

    /**
     * test for eatAnimal/eatPlant
     *
     * @return (true if passed, false if not)
     */
    public static boolean unitTest2()
    {
        Tiger tiger = new Tiger(7, 500, 250);
        Elephant elephant = new Elephant(7, 700, 150);
        elephant.eatPlant();
        if(elephant.getStrength() > 190 || elephant.getStrength() < 150) 
            return false;
        tiger.eatAnimal(elephant);
        if(tiger.getStrength() >  313 || tiger.getStrength() < 300) 
            return false;

        return true;
    }

    /**
     * test for poisonAnimal
     *
     * @return (true if passed, false if not)
     */
    public static boolean unitTest3()
    {
        int snakeCount = 0;
        int frogCount = 0;
        Snake snake = new Snake(7, 200, 150);
        Frog frog = new Frog(3, 85, 20);

        for(int i=0; i<10000; ++i)
        {
            if(snake.poisonAnimal())
                snakeCount++;
            if(frog.poisonAnimal())
                frogCount++;
        }
        //set the range wider than the real percentages,
        //less chance of failing. The numbers are in fact around 2000 and 4000
        if(frogCount>3000) return false;
        if(snakeCount>5000) return false;

        return true;
    }

    /**
     * test for fight
     *
     * @return (true if passed, false if not)
     */
    public static boolean unitTest4()
    {
        Tiger tiger = new Tiger(7, 600, 250);
        Elephant elephant = new Elephant(7, 700, 50);
        Snake snake = new Snake(7, 200, 150);
        Frog frog = new Frog(3, 85, 20);
        if(AnimalActivities.fight(snake, frog) == 2) return false;
        if(AnimalActivities.fight(tiger, elephant) != 1) return false;

        return true;
    }

    /**
     * test for reproduction
     *
     * @return (true if passed, false if not)
     */
    public static boolean unitTest5()
    {
        Tiger tiger1 = new Tiger(7, 500, 200);
        Tiger tiger2 = new Tiger(7, 500, 300);
        Tiger tiger3 = new Tiger(3, 300, 80);
        Animal tiger4 = new Tiger(7, 500, 250);
        Lion lion = new Lion(7, 650, 300);
        if(!(AnimalActivities.reproduce(tiger1, tiger2) instanceof Tiger)) return false;
        if(AnimalActivities.reproduce(tiger1, tiger2).getAge() !=0) return false;
        if(AnimalActivities.reproduce(tiger1, tiger2).getHealth() !=100) return false;
        if(AnimalActivities.reproduce(tiger1, tiger2).getStrength() !=250) return false;
        if(!(AnimalActivities.reproduce(tiger2, tiger3) instanceof Animal)) return false;
        if(AnimalActivities.reproduce(tiger2, tiger3) instanceof Tiger) return false;
        if(!(AnimalActivities.reproduce(lion, tiger1) instanceof Animal)) return false;
        if(AnimalActivities.reproduce(lion, tiger1) instanceof Tiger) return false;
        if(AnimalActivities.reproduce(lion, tiger1) instanceof Lion) return false;
        if(!(AnimalActivities.reproduce(tiger1, tiger4) instanceof Tiger)) return false;
        if(!(AnimalActivities.reproduce(lion, tiger4) instanceof Animal)) return false;
        if(AnimalActivities.reproduce(lion, tiger4) instanceof Tiger) return false;
        if(AnimalActivities.reproduce(lion, tiger4) instanceof Lion) return false;

        return true;
    }
}
