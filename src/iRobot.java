import antlr.collections.impl.Vector;

public class iRobot {
    public final double STEP_SIZE = 1;
    public final Vector2d DEFAULT_POSITION = new Vector2d(18, 18);
    //public final double DEFAULT_DIRECTION = 0;
    public Vector2d position;
    private int radius = 2; // ?
    private Map map;
    private double frontSensor;
    private double rightSensor;
    private double leftSensor;
    private double backSensor;
    private double angle = 0;
    private double deltaAngle = 0;

    public iRobot(Map map){
        this.position = DEFAULT_POSITION;
        this.map = map;
        updateSensors();
        System.out.println(map.width + " " + map.height);
        System.out.println("BEGINNNING");
    }

    public int getRadius(){
        return radius;
    }

    public double getRightSensor(){
        return rightSensor;
    }

    public double getLeftSensor(){
        return leftSensor;
    }

    public double getBackSensor(){
        return backSensor;
    }

    public double getFrontSensor(){
        return frontSensor;
    }

    public Vector2d getPosition(){
        return position;
    }

    public void setAngle(double value) {
        this.angle += value;
        if(angle > 180){
            this.angle = angle - 360;
        }
        else if(angle < -180){
            this.angle = angle + 360;
        }

        if(angle >= 0 && angle <= 90){
            this.deltaAngle = angle;
        }
        else if(angle > 90 && angle <= 180){
            this.deltaAngle = angle - 90;
        }
        else if(angle < 0 && angle >= -90){
            this.deltaAngle = 90 + angle;
        }
        else{
            this.deltaAngle = 180 + angle;
        }
    }

    private void updateSensors(){
        if(angle >= 0 && angle <= 90) {
            this.frontSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(90 - deltaAngle)), position.y / Math.cos(Math.toRadians(deltaAngle))) - radius);
            this.rightSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(90 - deltaAngle))) - radius);
            this.leftSensor = Math.max(0.0, Math.min(position.x / Math.cos(Math.toRadians(deltaAngle)), position.y / Math.sin(Math.toRadians(deltaAngle))) - radius);
            this.backSensor = Math.max(0.0, Math.min(position.x / Math.sin(Math.toRadians(deltaAngle)), (map.height - position.y) / Math.cos(Math.toRadians(deltaAngle))) - radius);
        }
        else if(angle > 90 && angle <= 180){
            this.leftSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(90 - deltaAngle)), position.y / Math.cos(Math.toRadians(deltaAngle))) - radius);
            this.frontSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(90 - deltaAngle))) - radius);
            this.backSensor = Math.max(0.0, Math.min(position.x / Math.cos(Math.toRadians(deltaAngle)), position.y / Math.sin(Math.toRadians(deltaAngle))) - radius);
            this.rightSensor = Math.max(0.0, Math.min(position.x / Math.sin(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(deltaAngle))) - radius);
        }
        else if(angle < -90 && angle >= -180){
            this.backSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(90 - deltaAngle)), position.y / Math.cos(Math.toRadians(deltaAngle))) - radius);
            this.leftSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(90 - deltaAngle))) - radius);
            this.rightSensor = Math.max(0.0, Math.min(position.x / Math.cos(Math.toRadians(deltaAngle)), position.y / Math.sin(Math.toRadians(deltaAngle))) - radius);
            this.frontSensor = Math.max(0.0, Math.min(position.x / Math.sin(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(deltaAngle))) - radius);
        }
        else{
            this.rightSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(90 - deltaAngle)), position.y / Math.cos(Math.toRadians(deltaAngle))) - radius);
            this.backSensor = Math.max(0.0, Math.min((map.width - position.x -1) / Math.cos(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(90 - deltaAngle))) - radius);
            this.frontSensor = Math.max(0.0, Math.min(position.x / Math.cos(Math.toRadians(deltaAngle)), position.y / Math.sin(Math.toRadians(deltaAngle))) - radius);
            this.leftSensor = Math.max(0.0, Math.min(position.x / Math.sin(Math.toRadians(deltaAngle)), (map.height - position.y -1) / Math.cos(Math.toRadians(deltaAngle))) - radius);
        }

        System.out.println(frontSensor / 10.0 + " " + rightSensor / 10.0 + " " + leftSensor / 10.0 + " " + backSensor / 10.0);
    }

    private Vector2d summand(){
        Vector2d summand;
        if( angle > 0){  // 1 quarter and 2 quarter
            summand = new Vector2d (STEP_SIZE * Math.sin(Math.toRadians(angle)), -STEP_SIZE * Math.cos(Math.toRadians(angle)));
        }
        else {
            summand = new Vector2d (STEP_SIZE * Math.sin(Math.toRadians(180-angle)), STEP_SIZE * Math.cos(Math.toRadians(180-angle)));
        }
        return summand;
    }

    public void move(){
        Vector2d summand = summand();
        if(map.canMoveTo(position.add(summand))) {
            position = position.add(summand);
        }
        //position = position.add(new Vector2d(3.53, -3.53));
        this.updateSensors();
    }
}
