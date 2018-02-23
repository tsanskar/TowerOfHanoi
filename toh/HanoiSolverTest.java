package toh;

public class HanoiSolverTest extends student.TestCase{
	
	
	private HanoiSolver test1;
	
	public void setUp()
	{
		test1 = new HanoiSolver(3);
	}	

	public void testNumberOfDisc()
	{
		assertEquals(3, test1.numberOfDisc());
		
	}
	
	public void testGetTower(){
		assertEquals(test1.left, test1.getTower(Position.LEFT));
	}
	
	public void testToString() 
	{
		Disc tempDisc1 = new Disc(5);
		Disc tempDisc2 = new Disc(7);
		Disc tempDisc3 = new Disc(10);
		
		test1.left.push(tempDisc1);
		test1.mid.push(tempDisc2);
		test1.right.push(tempDisc3);
		
		assertEquals("[5][7][10]",test1.toString());
		
	}
	
	
}
