public class test {
    public static void main(String[] args) {

        ObjectPoint objectPoint1 = new ObjectPoint(6,10, "Assaf");
        ObjectPoint objectPoint2 = new ObjectPoint(2,3, "Refael");
        ObjectPoint objectPoint3 = new ObjectPoint(3,2, "Yanay");
        ObjectPoint objectPoint4 = new ObjectPoint(14,2, "Itay");
        ObjectPoint objectPoint5 = new ObjectPoint(5,6, "Oren");
        ObjectPoint objectPoint6 = new ObjectPoint(15,1, "Keren");
        ObjectPoint objectPoint7 = new ObjectPoint(18,33, "Roei");

        CordinatesAVL<ObjectPoint> myAVL = new CordinatesAVL<>();
        myAVL.insertCoordinate(objectPoint1);
        myAVL.insertCoordinate(objectPoint2);
        myAVL.insertCoordinate(objectPoint3);
        myAVL.insertCoordinate(objectPoint4);
        myAVL.insertCoordinate(objectPoint5);
        myAVL.insertCoordinate(objectPoint6);
        myAVL.insertCoordinate(objectPoint7);








    }
}
