package toh;

public class LinkedStackTest extends student.TestCase{
	
	LinkedStack<String> test1;
	LinkedStack<String> test2;
	LinkedStack<String> test3;
	
	
	public void setUp(){
		
		test1 = new LinkedStack<String>();
		test2 = new LinkedStack<String>();
		test3 = null;
		
	}
	
	public void testSize()
	{
		assertTrue(test1.size() == 0);
		assertFalse(test2.size() == 5);
		
		test1.push("X");
		test1.push("Y");
		
		assertEquals(2, test1.size());
	}
	
	public void testIsEmpty()
	{
		assertTrue(test1.isEmpty());
		
		test1.push("A");
		test2.push("B");
		
		assertFalse(test1.isEmpty());
	
	}
	
	public void testPush()
	{
		test1.push("A");
		assertEquals(1, test1.size());
		test1.push("B");
		assertEquals(2, test1.size());
		
		
	}
	
	public void testPop()
	{
		test1.push("A");
		test1.push("B");
		assertEquals("B", test1.pop());
		assertEquals("A", test1.pop());
		
	}
	
	public void testPeek()
	{
		
		test1.push("1");
		test1.push("2");
		
		assertEquals("2", test1.peek());
		test1.pop();
		assertEquals("1", test1.peek());
		
	}
	
	public void testClear()
	{
		test2.push("1");
		test2.push("2");
		test2.push("5");
		
		test2.clear();
		
		assertTrue(test2.isEmpty());
	}
	
	public void testToString()
	{
		test2.push("A");
		test2.push("B");
		test2.push("C");
		
		assertEquals("[C,B,A]", test2.toString());
	}

}
