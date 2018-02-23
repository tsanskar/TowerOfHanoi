package toh;

import java.util.Observable;


public class HanoiSolver extends Observable{

	Tower left;
	Tower mid;
	Tower right;
	
	int numberOfDisc;
	
	public HanoiSolver(int numberOfDisc)
	{
		this.numberOfDisc = numberOfDisc;
		
		left = new Tower(Position.LEFT);
		mid = new Tower(Position.MIDDLE);
		right = new Tower(Position.RIGHT);
	}
	
	public int numberOfDisc(){
		return numberOfDisc;
	}
	
	public Tower getTower(Position pos)
	{
		if(pos.equals(Position.LEFT)){
			return left;
		}
		
		else if(pos.equals(Position.MIDDLE)){
			return mid;
		}
		
		else if(pos.equals(Position.RIGHT)){
			return right;
		}
		
		else
			return left;
	}
	
	public String toString()
	{
		return left.toString() + mid.toString() + right.toString();
	}
	
	public void move (Tower source, Tower destination)
	{
		destination.push(source.pop());
		setChanged();
		notifyObservers(destination.getPosition());
		
		
	}
	
	public void solveTower(int currentDisc, Tower startTower, Tower tempTower, Tower endTower )
	{
		if(currentDisc >= 1)
		{
			solveTower(currentDisc - 1, startTower, endTower, tempTower);
			move(startTower, endTower);
			solveTower(currentDisc - 1, tempTower, startTower, endTower);
		}	
	}
	
	
	public void solve()
	{
		solveTower(numberOfDisc, left, mid, right);
	}
}
