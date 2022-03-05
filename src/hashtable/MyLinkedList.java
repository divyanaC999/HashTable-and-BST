package hashtable;

public class MyLinkedList<K> {

	INode<K> head;
	INode<K> tail;

	public void add(INode<K> newNode) {
		if (head == null) {
			head = newNode;
		}
		if (tail == null) {
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public INode<K> pop() {
		INode<K> tempNode = head;
		head = head.getNext();
		tempNode.setNext(null);
		return tempNode;
	}

	public INode<K> popLast() {
		INode<K> tempNode = head;
		while (tempNode.getNext().getNext() != null) {
			tempNode = tempNode.getNext();
		}
		INode<K> lastNode = tempNode.getNext();
		tempNode.setNext(null);
		return lastNode;
	}

	public boolean search(INode<K> searchNode) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(searchNode.getKey())) {
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}

	public boolean insert(K after, INode<K> newNode) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(after)) {
				INode<K> node = tempNode.getNext();
				tempNode.setNext(newNode);
				newNode.setNext(node);
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	public boolean remove(K value) {
		INode<K> tempNode = head;
		if (tempNode.getKey().equals(value)) {
			head = tempNode.getNext();
			return true;
		}
		while (tempNode.getNext() != null) {
			if (tempNode.getNext().getKey().equals(value)) {
				tempNode.setNext(tempNode.getNext().getNext());
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	public int size() {
		int size = 0;
		INode<K> tempNode = head;
		while (tempNode != null) {
			tempNode = tempNode.getNext();
			size++;
		}
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void printMyNodes() {
		System.out.println("My nodes : " + head);
	}

	@Override
	public String toString() {
		return head.toString();
	}
}
