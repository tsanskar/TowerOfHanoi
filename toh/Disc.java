package toh;

import java.awt.Color;
import CS2114.Shape;


public class Disc extends Shape implements Comparable<Disc> {

	
	public Disc(int width)
	{
		super(0, 0, width, 10);
		Color color = new Color(10, 20, 30);
		this.setBackgroundColor(color);
	}
	
	public int compareTo(Disc otherDisc)
	{
		if ( otherDisc == null)
			throw new IllegalArgumentException("invalid disc");
		
		else if( this.getWidth() < otherDisc.getWidth())
			return -1;
		
		else if  (this.getWidth() > otherDisc.getWidth())
			return 1;
		return 0;
		
	}
	
	public boolean equals ( Object obj)
	{
		if ( obj == null)
			return false;
		if (obj == this)
			return true;
		if(obj.getClass().equals(this.getClass())){
			Disc temp = (Disc) obj;
			
			return temp.getWidth() == this.getWidth();
		}
		return false;
			
	}
	
	public String toString()
	{
		String discWidth = Integer.toString(this.getWidth());
		return discWidth;
	}
}
