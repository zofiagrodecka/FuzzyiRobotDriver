import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppFrame extends JFrame implements KeyListener {
    private Map map;
    private AppPanel panel;
    private Simulation simulation;

    public AppFrame(Map map, AppPanel panel, Simulation simulation) {
        super("iRobot fuzzy driver");
        this.map = map;
        this.panel = panel;
        this.simulation = simulation;

        addKeyListener(this);
        add(panel);
        pack();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            //System.out.println("SPACE TYPED");
            simulation.paused = !simulation.paused;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
