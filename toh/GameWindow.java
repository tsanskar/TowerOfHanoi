package toh;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * The GameWindow class creates the window and required attributes.
 *
 * @author Sanskar Thapa <tsanskar>
 * @version 2016.26.09
 */
public class GameWindow implements Observer
{
    /**
     * game is used to solve the puzzle.
     */
    HanoiSolver game;

    /**
     * left is the left pillar.
     */
    Shape       left;

    /**
     * left is the left pillar.
     */
    Shape       bottom;

    /**
     * right is the right pillar.
     */
    Shape       right;

    /**
     * middle is the middle pillar.
     */
    Shape       middle;

    /**
     * thisWindow is the skin of the program
     */
    Window      thisWindow;

    /**
     * currentDisc is the disc used in operation
     */
    Disc        currentDisc;

    /**
     * currentPole is the shape used to process the pillars.
     */
    Shape       currentPole;

    /**
     * constant for the gap between discs.
     */
    final int   DISK_GAP    = 5;

    /**
     * constant for height of the discs.
     */
    final int   DISK_HEIGHT = 150;


    /**
     * updates method updates the position of the discs.
     * 
     * @param o
     *            used to observe the discs movements @ param arg used to hold
     * the passed position
     */
    public void update(Observable o, Object arg)
    {
        if (arg.getClass().equals(Position.class))
        {
            Position args = (Position)arg;
            this.moveDisc(args);
            this.sleep();
        }
    }


    /**
     * GameWindow is the constructor and gives the variables.
     * 
     * @param game
     *            holds the solving algorithm.
     */
    public GameWindow(HanoiSolver game)
    {

        this.game = game;
        game.addObserver(this);
        thisWindow = new Window();
        thisWindow.setTitle("Tower of Hanoi");
        thisWindow.setSize(800, 900);

        Button solve = new Button("Solve");
        thisWindow.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this);

        left = new Shape(thisWindow.getGraphPanelWidth() / 4, thisWindow.getGraphPanelHeight()/5, 5, 200,
                Color.BLACK);
        right = new Shape(3 * thisWindow.getGraphPanelWidth() / 4, thisWindow.getGraphPanelHeight()/5, 5, 200,
                Color.BLACK);
        middle = new Shape(thisWindow.getGraphPanelWidth() / 2, thisWindow.getGraphPanelHeight()/5, 5, 200,
                Color.BLACK);

        bottom = new Shape(left.getX(), thisWindow.getGraphPanelHeight()/5
        		+ left.getHeight(), right.getX()- left.getX()+ right.getWidth(), 5, Color.BLACK);
        
        for (int i = 0; i < game.numberOfDisc(); i++)
        {
            
            Tower currentTower = game.getTower(Position.LEFT);
            currentDisc = new Disc(20 * game.numberOfDisc() - 10* i);
            currentTower.push(currentDisc);
            thisWindow.addShape(currentDisc);
            this.moveDisc(Position.LEFT);
        }

        thisWindow.addShape(left);
        thisWindow.addShape(middle);
        thisWindow.addShape(right);
        thisWindow.addShape(bottom);

    }


    /**
     * getWindow returns the window.
     * 
     * @return thisWindow returns the window.
     */
    public Window getWindow()
    {
        return thisWindow;
    }


    /**
     * moveDisc operates the movement of the disc
     * 
     * @param position
     *            holds the position of discs passed
     */
    private void moveDisc(Position position)
    {
        Tower currentTower = game.getTower(position);

        if (currentTower.getPosition().equals(Position.LEFT))
        {
            currentPole = left;
            currentDisc = game.getTower(position).peek();
            currentDisc.moveTo(currentPole.getX() - currentDisc.getWidth()/2 + 2,
                currentPole.getHeight() - 10*(game.getTower(position).size()) + 150);
            
        }
        else if (currentTower.getPosition().equals(Position.MIDDLE))
        {
            currentPole = middle;
            currentDisc = game.getTower(position).peek();
            currentDisc.moveTo(currentPole.getX() - currentDisc.getWidth()/2 + 2,
                currentPole.getHeight() - 10*(game.getTower(position).size()) + 150);
        }

        else if (currentTower.getPosition().equals(Position.RIGHT))
        {
            currentPole = right;
            currentDisc = game.getTower(position).peek();
            currentDisc.moveTo(currentPole.getX() - currentDisc.getWidth()/2 + 2,
                currentPole.getHeight() - 10*(game.getTower(position).size()) + 150);
        }

        else
        {

            currentPole = left;
            currentDisc = game.getTower(position).peek();
            currentDisc.moveTo(currentPole.getX() - currentDisc.getWidth()/2 + 2,
                currentPole.getHeight() - 10*(game.getTower(position).size()) + 150);
        }
    }


    /**
     * sleep delays the operation to make it visible
     */
    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }


    /**
     * clickedSolve solves the operation when the button is hit
     * 
     * @param button
     *            holds the solve button
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }

}
