package hashtable;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {

	private final int numBuckets;
	private ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap() {
		numBuckets = 10;
		myBucketArray = new ArrayList<>(numBuckets);
		for (int i = 0; i < numBuckets; i++) {
			myBucketArray.add(new MyLinkedList<K>());
		}
	}

	private int getBucketIndex(K key) {
		int index = Math.abs(key.hashCode()) % numBuckets;
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if (myLinkedList.isEmpty()) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return myMapNode == null ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>();
			myMapNode.setKey(key);
			myMapNode.setValue(value);
			myLinkedList.add(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public int size() {
		int size = 0;
		for (MyLinkedList<K> myLinkedList : myBucketArray) {
			size += myLinkedList.size();
		}
		return size;
	}

	public boolean remove(K key) {
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		return myLinkedList.remove(key);
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < myBucketArray.size(); i++) {
			if (!myBucketArray.get(i).isEmpty()) {
				strBuilder.append("\nMyHashTable{" + i + "," + myBucketArray.get(i) + "}->");
			}
		}
		return strBuilder.toString();
	}
}
