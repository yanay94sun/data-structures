
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
		// TODO Auto-generated method stub
		return null;
	}

}
