package toh;

public class Tower extends LinkedStack<Disc>{

	private Position position;
	
	public Tower(Position givenPosition)
	{
		super();
		this.position = givenPosition;
		
	}
	
	public Position getPosition()
	{
		return position;
		
	}
	
	public void push(Disc givenDisc)
	{
		if (this.isEmpty())
		{
			super.push(givenDisc);;
			
		}
		else if(this.peek().compareTo(givenDisc) < 0)
		{
			throw new IllegalStateException("Invalid stack");			
		}
		
		else
			super.push(givenDisc);
		
	}
	
}
