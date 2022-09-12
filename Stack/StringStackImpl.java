import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringStackImpl implements StringStack{
	public ListNode first;
	
	public StringStackImpl(){
		first=null;
	}
	
	@Override
	public boolean isEmpty() {
		return (first==null);
	}

	@Override
	public void push(String item){
		ListNode n = new ListNode(item);
		n.next=first;
		first=n;
	}

	@Override
	public String pop() throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("Stack Is Empty.");
		}
		else{			
			String firstNodeItem = (String) first.getElement();
			
			if(first.getNext() == null)	first = null;
			else first=first.next;
			return firstNodeItem;
		}
	}
		

	@Override
	public String peek() throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException("Stack Is Empty.");
		}
		else return (String) first.getElement();
	}
	

	@Override
	public void printStack(PrintStream stream) {
		if(isEmpty()){
			stream.println("Stack is empty.");
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
			int i=0;
			ListNode node = first;
			
			while (node!=null){
				i++;
				node = node.next;
			}
			
			return i;
		}
	}


