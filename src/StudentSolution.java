import java.util.ArrayList;

public class StudentSolution  implements MyInterface{
	CordinatesAVL<ObjectWithCoordinates> cordinatesAVL = new CordinatesAVL<ObjectWithCoordinates>();

	@Override
	public void insertDataFromDBFile(String objectName, int objectX, int objectY) {
		cordinatesAVL.insertCoordinate(new ObjectPoint(objectX, objectY, objectName));
		
	}
	
	@Override
	public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX,
			int rightBottomY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] secondSolution(int leftTopX, int leftTopY,
			int rightBottomX, int rightBottomY) {
		ArrayList<ObjectWithCoordinates> listX =cordinatesAVL.getAvlx().range(leftTopX, rightBottomX);
		ArrayList<ObjectWithCoordinates> listY =cordinatesAVL.getAvly().range(leftTopY, rightBottomY);
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
