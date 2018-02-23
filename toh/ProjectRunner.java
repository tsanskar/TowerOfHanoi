package toh;

import toh.GameWindow;

public class ProjectRunner {

	
	public ProjectRunner()
	{
		
	}
	
	public ProjectRunner(String[] args)
	{
		
	}
	
	public static void main(String [] args)
	{
		int discNumber = 5;
		Disc disc = new Disc(discNumber);
		if(args.length == 1)
		{
			discNumber = Integer.parseInt(args[0]);
			disc = new Disc(discNumber);
		
		}
			HanoiSolver game = new HanoiSolver(discNumber);
			GameWindow thisWindow = new GameWindow(game);
		
	}
}
