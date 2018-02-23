package toh;


public class DiscTest extends student.TestCase{
	
	
	Disc test1;
	Disc test2;
	Disc test3;
	
	public void setUp()
	{
		
		test1 = new Disc(5);
		test2 = new Disc(10);
		test3 = new Disc(10);
		
	}
	
	public void testCompareTo()
	{
		assertEquals(-1, test1.compareTo(test2));
		
		assertEquals(1, test2.compareTo(test1));
		
	}
	
	public void testEquals()
	{
		assertTrue(test2.equals(test3));
		assertFalse(test1.equals(test2));
	
	}
	
	public void testToString()
	{
		assertEquals("5", test1.toString());
		
	}
}
