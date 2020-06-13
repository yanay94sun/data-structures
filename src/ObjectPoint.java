public class ObjectPoint implements ObjectWithCoordinates{
    private int x;
    private int y;
    private String name;

    public ObjectPoint(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public Object getData() {
        return this;
    }

    @Override
    public String toString() {
        return  this.name +
                " x=" + x +
                " y=" + y;
    }
}
