/**
 * ListNode represents a signed-link list node
 * Each node contains an Object reference to data and a reference to the next node in the list.
*/
class ListNode
{
	// package access members; List can access these directly
	protected Object element;
	protected ListNode next;

	/**
	 * Constructor. It initializes data and sets next node to null
	 * @param element a reference to node's data
	*/
	ListNode( Object element )
	{
		this(element, null);

	} // end ListNode one-argument constructor

	/**
	 * constructor creates ListNode with passed data and next node
	 * @param element the reference to node's data
	 * @param node the next node in the list
	*/
	ListNode( Object element, ListNode node )
	{
		this.element = element;
		this.next = node;

	} // end ListNode two-argument constructor

	/**
	 * Returns this node's data
	 * @return the reference to node's data
	*/
	Object getElement()
	{
		return this.element;

	} // end method getObject

	/**
	 * Get reference to next node
	 * @return the next node
	*/
	ListNode getNext()
	{
		return this.next;

	} // end method getNext
} // end class ListNode
