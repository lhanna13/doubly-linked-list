/*
 * Doubly linked list class demonstrates how a doubly linked list works.
 * Can insert employees into list and delete employees in list.
 * @author Lauren Hanna
 */
public class DoublyLinkedList {

	Employee firstLink; //Most recently added link 
	Employee lastLink;//Least recently added link
	
	/*
	 * @return true if the doubly linked list is empty.
	 */
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	/*
	 * Inserts new employee into first position in doubly linked list
	 * @param employeeName:new  employees name, employeeID: new employees ID number
	 */
	public void insertIntoFirstPosition(String employeeName, int employeeID){
		Employee newEmployee = new Employee( employeeName, employeeID);
		if(isEmpty()){
			
			lastLink = newEmployee;
		}
		else{
			firstLink.previous = newEmployee;
		}
		newEmployee.next = firstLink;
		firstLink = newEmployee;
	}
	
	/*
	 * Inserts new employee into last position in doubly linked list
	 * @param employeeName:new  employees name, employeeID: new employees ID number
	 */
	public void insertIntoLastPosition(String employeeName, int employeeID){
		Employee newLink = new Employee(employeeName, employeeID);
		if(isEmpty()){
			firstLink = newLink;//first link like first link put in ever
		}
		else{
			lastLink.next = newLink;
			newLink.previous = lastLink;
		}
		lastLink = newLink;
		}
	
	/*
	 * Inserts new employee after given key number in doubly linked list
	 * @param employeeName:new  employees name, employeeID: new employees ID number
	 * key: the employeeId number of the employee you want to insert the new employee before.
	 * @return true if new employee is inserted into doubly linked list,
	 * false is new employee is not inserted.
	 */
	public boolean insertAfterTheGivenKey(String employeeName, int employeeID, int key){
		Employee newEmployee = new Employee(employeeName, employeeID);
		
		Employee currentEmployee = firstLink;
		
		while(currentEmployee.employeeID != key){
			currentEmployee = currentEmployee.next;
			
			if(currentEmployee == null){
				System.out.println("Couldn't find employee with given Id key");
			return false;
			}
		}
		//if the key matches the last link added to the list
		if(currentEmployee == lastLink){ 
			newEmployee.next = null;
			lastLink = newEmployee;
		}
		//If the key matches a link in the middle of the list
		else{
			newEmployee.next = currentEmployee.next;
			currentEmployee.next.previous = newEmployee;
		}
		newEmployee.previous = currentEmployee;
		currentEmployee.next = newEmployee;
		return true;
	}
	
	/*
	 * Use key to locate specific employee and inserts new employee before the employee
	 * with the key id number.
	 * @param employeeName: the employees name, employeeID: the employees ID number, 
	 * key: the employeeId number of the employee you want to insert the new employee before.
	 * @return true if new employee is inserted into doubly linked list,
	 * false is new employee is not inserted.
	 */
	public boolean insertBeforeAGivenKey(String employeeName, int employeeID, int key){
		Employee newEmployee = new Employee(employeeName, employeeID);
		Employee currentEmployee = firstLink;
		
		while(currentEmployee.employeeID != key){
			currentEmployee = currentEmployee.next;
			
			if(currentEmployee == null){
				System.out.println("Couldn't find employee with given Id key");
			return false;
			}
		}
		//if the key matches the first link added in the list
				if(currentEmployee == firstLink){ 
					newEmployee.previous = null;
					firstLink = newEmployee;
				}
				//If the key matches a link in the middle of the list
				else{
					newEmployee.previous = currentEmployee.previous;
					currentEmployee.previous.next = newEmployee;
				}
				newEmployee.next = currentEmployee;
				currentEmployee.previous = newEmployee;
				return true;
		
	}
	
	/*
	 * Deletes the employee whose ID number matches the key
	 * @return Employee that was deleted
	 */
	public Employee deleteEmployee(int key){
		DoublyLinkedList DLL = new DoublyLinkedList();
		Employee currentEmployee = firstLink;
		
		while(currentEmployee.employeeID != key){
			currentEmployee = currentEmployee.next;
			//Can't find employee with id number matching key
			if(currentEmployee == null){
				return null;
			}
		}
		
		//If match found is first link in doubly linked list
		if(currentEmployee.previous == null){
			currentEmployee = currentEmployee.next;
			currentEmployee.previous = null;
			firstLink = currentEmployee;
		}
		//If match found is last link in doubly linked list
		else if(currentEmployee.next == null){
			currentEmployee = currentEmployee.previous;
			currentEmployee.next= null;
			lastLink = currentEmployee;
		}
		//If it's a middle link
		else{
			currentEmployee.previous.next = currentEmployee.next;
			currentEmployee.next.previous = currentEmployee.previous;
		}
		return currentEmployee;
		
	}
	
	/*
	 * Prints out the employees names and ID numbers.
	 */
	public void displayAll(){
		Employee employee = firstLink;
		while(employee != null){
			System.out.println("Employee Name: " + employee.employeeName + "      EmployeeID: " + employee.employeeID );
			employee = employee.next; //Move to the next link
		}
	}
	/*
	 * Main Method. Add some Employees to doubly linked list, then display them all.
	 */
	public static void main(String[] args) {
		
		DoublyLinkedList DLL = new DoublyLinkedList();
		
		DLL.insertIntoFirstPosition("Lauren", 101);
		DLL.insertIntoFirstPosition("Joshua", 102);
		DLL.insertIntoFirstPosition("Sammy", 103);
		DLL.insertIntoLastPosition("Thomas", 104);
		DLL.insertAfterTheGivenKey("Kayla", 105, 102); //inserts Kayla after Joshua
		DLL.insertIntoLastPosition("Elizabeth", 107);
		DLL.insertIntoLastPosition("Brady", 108);
		DLL.insertBeforeAGivenKey("Amanda", 109, 104);//insert Amanda before Thomas
		DLL.displayAll();
		System.out.println();
		DLL.deleteEmployee(103);
		DLL.deleteEmployee(101);
		DLL.deleteEmployee(108);
		DLL.displayAll();
	}
}

/*
 * Node class named Employee
 * @author Lauren Hanna
 */
class Employee{
	public String employeeName;
	public int employeeID;
	
	public Employee next; //link to next employee
	public Employee previous; //link to previous employee
	
	/*
	 * Creates a new employee
	 * @param employeeName: the employees name, employeeID: the employees ID number
	 */
	public Employee(String employeeName, int employeeID){
		this.employeeName = employeeName;
		this.employeeID = employeeID;
	}
	
	/*
	 * Displays the employees name and employeeID
	 */
	public void display(){
		System.out.println(employeeName + " : " + employeeID);
	}
}


/*
 * Class EmployeeIterator gives us a way to iterate through out doubly linked list.
 */
class EmployeeIterator{
	
	Employee currentEmployee;
	Employee previousEmployee;
	int size = 0;
	
	DoublyLinkedList doublyLinkedList;
	
	//Gets passed a Doubly LinkedList
	public EmployeeIterator(DoublyLinkedList doublyLinkedList){
		
		this.doublyLinkedList = doublyLinkedList;
		currentEmployee = doublyLinkedList.firstLink;
		previousEmployee = doublyLinkedList.lastLink;
		
	}
	
	/*
	 * Finds and returns the specified employee.
	 */
	public Employee getEmployee(String employeeName, int employeeID){
		
		EmployeeIterator it = new EmployeeIterator(doublyLinkedList);
		while((it.currentEmployee.employeeID != employeeID) && (it.currentEmployee.employeeName != employeeName)){
			if(it.currentEmployee.next == null){
				return null; //can't find a match
			}
			else{
			it.currentEmployee = it.currentEmployee.next;
			}
		}
		
		return it.currentEmployee;
		
	}
	
	/*
	 * Return the size of the doubly linked list.
	 */
	public int sizeOfList(DoublyLinkedList doublyLinkedList){
		currentEmployee = doublyLinkedList.firstLink;
		size++;
		while((hasNext()) && (currentEmployee.next != null)){
			System.out.println(currentEmployee.employeeName);
			size++; 
			currentEmployee = currentEmployee.next;
		}
		
		return size;
		
		
	}
	
	/*
	 * Returns true if the iteration has more Employees.
	 */
	public boolean hasNext(){
		if(currentEmployee.next == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	/*
	 * Returns the next Employee.
	 */
	public Employee next(){
		if(hasNext()){
		previousEmployee = currentEmployee;
		currentEmployee = currentEmployee.next;
		
		return currentEmployee;
		}
		return null;
	}
}

