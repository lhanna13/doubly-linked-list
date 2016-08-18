import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

	/*
	 * Testing if when the doubly linked list is first created that it is empty.
	 */
	@Test
	public void testIsEmpty() {
		DoublyLinkedList DLL = new DoublyLinkedList();
		assertTrue(DLL.isEmpty());
	}
	
	/*
	 * Test if inserted item is inserted into first position.
	 */
	@Test
	public void testInsertIntoFirstPosition(){
		DoublyLinkedList DLL = new DoublyLinkedList();
		EmployeeIterator it = new EmployeeIterator(DLL);
		DLL.insertIntoFirstPosition("Lauren", 101);
		assertEquals(1 ,  it.sizeOfList(DLL) );
		assertEquals(DLL.firstLink, it.getEmployee("Lauren", 101));
		
	}
	
	/*
	 * Test if item inserted into last position is in last position.
	 */
	@Test
	public void testInsertIntoLastPosition(){
		DoublyLinkedList DLL = new DoublyLinkedList();
		EmployeeIterator it = new EmployeeIterator(DLL);
		DLL.insertIntoFirstPosition("Lauren", 101);
		DLL.insertIntoLastPosition("Joshua", 102);
		assertEquals(2 ,  it.sizeOfList(DLL) );
		assertEquals(DLL.lastLink, it.getEmployee("Joshua", 102));
	}
	
	/*
	 * Tests if employee was added to the doubly linked list after the given key.
	 */
	@Test
	public void  testInsertAfterTheGivenKey(){
		DoublyLinkedList DLL = new DoublyLinkedList();
		EmployeeIterator it = new EmployeeIterator(DLL);
		DLL.insertIntoFirstPosition("Lauren", 101);
		DLL.insertIntoLastPosition("Joshua", 102);
		DLL.insertIntoFirstPosition("Amanda", 103);
		DLL.insertIntoFirstPosition("April", 104);
		DLL.insertAfterTheGivenKey("Shannon", 105, 103);
		assertEquals(it.getEmployee("Amanda", 103).next , it.getEmployee("Shannon", 105));
	}
	
	
	/*
	 * Tests if employee was added to the doubly linked list before the given key.
	 */
	@Test
	public void  testInsertBeforeTheGivenKey(){
		DoublyLinkedList DLL = new DoublyLinkedList();
		EmployeeIterator it = new EmployeeIterator(DLL);
		DLL.insertIntoFirstPosition("Lauren", 101);
		DLL.insertIntoLastPosition("Joshua", 102);
		DLL.insertIntoFirstPosition("Amanda", 103);
		DLL.insertIntoFirstPosition("April", 104);
		DLL.insertBeforeAGivenKey("Shannon", 105, 103);
		assertEquals(it.getEmployee("Amanda", 103).previous , it.getEmployee("Shannon", 105));
	}
	
	/*
	 * Tests if employee was deleted from doubly linked list.
	 */
	@Test
	public void  testDeleteEmployee(){
		DoublyLinkedList DLL = new DoublyLinkedList();
		EmployeeIterator it = new EmployeeIterator(DLL);
		DLL.insertIntoFirstPosition("Lauren", 101);
		DLL.insertIntoLastPosition("Joshua", 102);
		DLL.insertIntoFirstPosition("Amanda", 103);
		DLL.insertIntoFirstPosition("April", 104);
		DLL.deleteEmployee(103);
		assertEquals(3 ,  it.sizeOfList(DLL) );

}
}