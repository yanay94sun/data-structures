import java.util.LinkedList;
public class HashTable {
	private int size = 11; // NEED TO CHECK WHICH NUMBER REPLACE M???!!!!!!
	private LinkedList[] table;

	public HashTable() {
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = null;
		}
	}
	public void insert(ObjectWithCoordinates object){
		int hash = h(object);
		if (table[hash] == null){
			table[hash] =  new LinkedList();
			table[hash].addFirst(object);
		}
		else {
			LinkedList input = table[hash];
			input.addFirst(object);

		}
	}

	public ObjectWithCoordinates search(int x, int y){
		int hash = (x + y)%11;
		if (table[hash] == null){
			return null;
		}
		else {

			LinkedList input = table[hash];
			int i = 0;
			while ((((ObjectWithCoordinates) input.get(i)).getX() != x) && ((((ObjectWithCoordinates) input.get(i)).getY()) != y)){
				if (input.getLast() == input.get(i)){
					return null;
				}
				i++;
				}
			return (ObjectWithCoordinates)input.get(i);
				}
	}






	public int h(ObjectWithCoordinates point){
		return (point.getX() + point.getY())%11;
	}
}

