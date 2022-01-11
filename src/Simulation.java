public class Simulation {
    private int DEFAULT_SPEED = 200; // ms
    private Map map;
    private AppPanel panel;
    private AppFrame frame;
    private FuzzyDriver driver;
    public boolean paused = false;

    public Simulation(String file) {
        this.map = new Map(36, 36);  // dm
        this.panel = new AppPanel(map);
        this.frame = new AppFrame(map, panel, this);
        this.driver = new FuzzyDriver(file);
    }

    public void start() throws InterruptedException {
        while(true){
            if (!paused) {
                panel.repaint();
                driver.setVariables(map.robot.getFrontSensor(), map.robot.getRightSensor(), map.robot.getLeftSensor(), map.robot.getBackSensor());
                double newAngle = driver.getResult();
                System.out.println("Obliczony kąt: " + newAngle);
                map.robot.setAngle(newAngle);
                map.robot.move();
                Thread.sleep(DEFAULT_SPEED);
            } else {
                while (paused) {
                    Thread.sleep(5);
                }
            }
        }
    }
}

