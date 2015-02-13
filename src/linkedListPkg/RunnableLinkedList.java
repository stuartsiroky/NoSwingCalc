package linkedListPkg;

public class RunnableLinkedList implements Runnable{

	@Override
	public void run() {
		LinkedList theList = new LinkedList();
		LinkedListIterator theItr;
		int i;

		theItr = theList.zeroth();
		printList(theList);

		for (i = 0; i < 10; i++) {
			theList.insert(new Integer(i), theItr);
			printList(theList);
			theItr.advance();
		}
		System.out.println("Size was: " + listSize(theList));

		for (i = 0; i < 10; i += 2)
			theList.remove(new Integer(i));
		
	}

	// Simple print method
	public static void printList(LinkedList theList) {
		if (theList.isEmpty())
			System.out.print("Empty list");
		else {
			LinkedListIterator itr = theList.first();
			for (; itr.isValid(); itr.advance())
				System.out.print(itr.retrieve() + " ");
		}

		System.out.println();
	}

	// In this routine, LinkedList and LinkedListIterator are the
	// classes written in Section 17.2.
	public static int listSize(LinkedList theList) {
		LinkedListIterator itr;
		int size = 0;

		for (itr = theList.first(); itr.isValid(); itr.advance())
			size++;

		return size;
	}
	
	
}
