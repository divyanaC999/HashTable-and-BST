package hashtable;

public class HashTableuc3 {

	public static void main(String[] args) {
		String str = "Paranoids are not\r\n" + "paranoid because they are paranoid but\r\n"
				+ "because they keep putting themselves\r\n" + "deliberately into paranoid avoidable\r\n"
				+ "situations";
		String[] words = str.split(" ");
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<String, Integer>();
		for (String word : words) {
			if (word.equals("avoidable")) {
				break;
			}
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
