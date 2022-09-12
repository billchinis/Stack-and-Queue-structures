import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl implements IntQueue{
	public ListNode first;
	public ListNode last;
	
	public IntQueueImpl() {
		first = last = null;
	}

	@Override
	public boolean isEmpty() {
		if(first==last && first==null){
			return true;
		}
		else{
			return false;
		}
	}		

	@Override
	public void put(int item) {
		ListNode node = new ListNode(item);
			
		if(isEmpty()){
			first = last = node;
		}
		else{
			last.next = node;
			last = node;
		}
	}

	@Override
	public int get() throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("Queue Is Empty.");
		}
		else{
			int firstNodeElement = (int) first.getElement();
			
			if(first.getNext() == null){
				first = last = null;
			}
			else{
				first = first.next;
			}
			
			return firstNodeElement;
		}
	}

	@Override
	public int peek() throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("Queue Is Empty.");
		}
		else{
			return (int) first.getElement();
		}
	}

	@Override
	public void printQueue(PrintStream stream) {
		if(isEmpty()){
			stream.println("Queue is empty.");
		}
		else{
			ListNode node = first;
			
			while(node!=null){
				stream.println(node.getElement());
				
				node = node.next;
			}
		}
	}

	@Override
	public int size() {
		if(isEmpty()){
			return 0;
		}
		else{
			int i=1;
			ListNode node = first;
			
			while (node!=last){
				i++;
				node = node.next;
			}
			
			return i;
		}
	}

}
