package hashtable;

public class MyMapNode<K, V> implements INode<K> {

	K key;
	V value;
	INode<K> next;

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public INode<K> getNext() {
		return next;
	}

	@Override
	public void setNext(INode<K> next) {
		this.next = next;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyMapNode{key=").append(key).append(",value=").append(value).append("}");
		if (next != null) {
			builder.append("->").append(next);
		}
		return builder.toString();
	}
}
