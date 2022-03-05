package hashtable;

public class HashTableuc1 {

	public static void main(String[] args) {
		String str = "to be or not to be";
		String[] words = str.split(" ");
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<String, Integer>();
		for (String word : words) {
			Integer value = myHashMap.get(word.toLowerCase());
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			myHashMap.add(word.toLowerCase(), value);
		}
		System.out.println(myHashMap);
		System.out.println("Size of Linked Hash Map : " + myHashMap.size());

	}

}
