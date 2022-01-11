import java.awt.*;
import javax.swing.*;

import static java.lang.Math.min;

public class AppPanel extends JPanel{
    private final int BEGIN_COORDINATES = 0;
    private final int MAX_SCREEN_WIDTH = 1300;
    private final int MAX_SCREEN_HEIGHT = 600;
    private final int MIN_CELL = 3;

    private final int width;
    private final int height;
    private final int cellWidth;
    private final int cellHeight;
    private final int cell;
    private final Map map;

    public AppPanel(Map map) {
        this.map = map;
        this.cellWidth = MAX_SCREEN_WIDTH/map.width;
        if(cellWidth < MIN_CELL){
            throw new IllegalArgumentException("Too big map width entered: " + map.width);
        }
        this.cellHeight = MAX_SCREEN_HEIGHT/map.height;
        if(cellHeight < MIN_CELL){
            throw new IllegalArgumentException("Too big map height entered: " + map.height);
        }

        this.cell = min(cellWidth, cellHeight);

        this.width = cell * map.width;
        this.height = cell * map.height;

        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        g.setPaint(new Color(241, 219, 111));
        g.fillRect(BEGIN_COORDINATES, BEGIN_COORDINATES, map.width * cell, map.height * cell);

        g.setPaint(new Color(0,0,0));
        //g.fillOval((int) (map.robot.getPosition().x-map.robot.getRadius()) * cell, (int) (map.robot.getPosition().y-map.robot.getRadius()) * cell, map.robot.getRadius()*2*cell, map.robot.getRadius()*2*cell);
        g.fillOval((int) (map.robot.getPosition().x-map.robot.getRadius() + 0.5) * cell, (int) (map.robot.getPosition().y-map.robot.getRadius() + 0.5) * cell, map.robot.getRadius()*2*cell, map.robot.getRadius()*2*cell);
    }

}
