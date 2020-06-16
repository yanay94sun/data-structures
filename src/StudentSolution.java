import java.util.ArrayList;

public class StudentSolution  implements MyInterface{
	CoordinatesAVL<ObjectWithCoordinates> coordinatesAVL = new CoordinatesAVL<>();

	@Override
	public void insertDataFromDBFile(String objectName, int objectX, int objectY) {
		coordinatesAVL.insertCoordinate(new ObjectPoint(objectX, objectY, objectName));
		
	}
	
	@Override
	public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
		ArrayList<String > resList = new ArrayList<>();
		ArrayList<ObjectWithCoordinates> listX = coordinatesAVL.getAvlx().range(leftTopX, rightBottomX);
		ArrayList<ObjectWithCoordinates> listY = coordinatesAVL.getAvly().range(leftTopY, rightBottomY);
		HashTable hashTable = new HashTable();
		for (ObjectWithCoordinates x : listX) {
			hashTable.insert(x);
		}
		for (ObjectWithCoordinates objectWithCoordinates : listY) {
			if (objectWithCoordinates.equals(hashTable.search(objectWithCoordinates.getX(), objectWithCoordinates.getY()))) {
				resList.add(objectWithCoordinates.toString());
			}
		}
		String [] arr = new String[resList.size()];
		for (int i = 0; i < resList.size(); i++){
			arr[i] = resList.get(i);
		}
		return arr;
	}







	@Override
	public String[] secondSolution(int leftTopX, int leftTopY,
			int rightBottomX, int rightBottomY) {
		ArrayList<ObjectWithCoordinates> listX = coordinatesAVL.getAvlx().range(leftTopX, rightBottomX);
		ArrayList<ObjectWithCoordinates> listY = coordinatesAVL.getAvly().range(leftTopY, rightBottomY);
		ArrayList<String > resList = new ArrayList<>();
		if (listX.size() <= listY.size()){
			for (ObjectWithCoordinates object : listX){
				if (object.getY() >= leftTopY && object.getY() <= rightBottomY){
					resList.add(object.toString());
				}
			}
		}
		else {
			for (ObjectWithCoordinates object : listY){
				if (object.getX() >= leftTopX && object.getX() <= rightBottomX){
					resList.add(object.toString());
				}
			}
		}
		String [] arr = new String[resList.size()];
		 for (int i = 0; i < resList.size(); i++){
		 	arr[i] = resList.get(i);
		 }
		 return arr;
	}

}
