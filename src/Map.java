public class Map {
    public final int width;
    public final int height;
    public final Vector2d lowerLeft;
    public final Vector2d upperRight;
    public final iRobot robot;

    public Map(int width, int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
        this.robot = new iRobot(this);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(this.width-1, this.height-1));
    }
}
