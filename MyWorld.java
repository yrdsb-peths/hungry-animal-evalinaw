import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in. felix was here
 * 
 * @author Wang
 * @version December 2022
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 3;
    int count;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
        
        createEvilStar();
    }
    public void act(){
        count++;
        if(count%200==0){
            createEvilStar();
        }
    }
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel1 = new Label("┌── ⋆⋅☆⋅⋆ ──┐", 100);
        Label gameOverLabel2 = new Label("game over !", 70);
        Label gameOverLabel3 = new Label("└── ⋆⋅☆⋅⋆ ──┘", 100);
        addObject(gameOverLabel3, 390, 200);
        addObject(gameOverLabel2, 300, 150);
        addObject(gameOverLabel1, 390, 100);
    }
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    /**
     * Create a new apple at random locations
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void createEvilStar()
    {
        EvilStar evilStar = new EvilStar();
        evilStar.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = -100;
        addObject(evilStar, x, y);
    }
    
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
    }
}
