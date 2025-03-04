import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example. This program will show a message in the center of the window with a 
 * styled, resized, colored backround and foreground font.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Alejandro Perez Jorda and Daniel Cater
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    // instance variables
    public FontMetrics fontMetrics;
    public int widthFont;
    public int heightFont;
    public int widthPanel;
    public int heightPanel;

    /**
    * 
    * Makes use of the paintComponent method to set up the JPanel interface. This method shows
    * a message in the center of the screen with a styled, resized, colored backround and foreground font.
    * 
    */
    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // Sky Background
        g.setColor(new Color(135, 206, 250)); // Light blue sky
        g.fillRect(0, 0, getWidth(), getHeight());

        // Sun
        g.setColor(Color.YELLOW);
        g.fillOval(280, 30, 40, 40);

        // Clouds
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 40, 30);
        g.fillOval(70, 40, 40, 30);
        g.fillOval(90, 50, 40, 30);

        g.fillOval(320, 50, 40, 30);
        g.fillOval(340, 40, 40, 30);
        g.fillOval(360, 50, 40, 30);

        // Birds 
        g.setColor(Color.BLACK);
        g.drawArc(60, 60, 15, 10, 0, 180);
        g.drawArc(75, 60, 15, 10, 0, 180);

        g.drawArc(360, 60, 15, 10, 0, 180);
        g.drawArc(375, 60, 15, 10, 0, 180);

        // Main Building 
        g.setColor(new Color(178, 34, 34));
        g.fillRect(50, 140, 300, 160);

        // Roof 
        g.setColor(new Color(60, 60, 60)); // Dark gray
        int[] xRoof = {40, 200, 360};
        int[] yRoof = {140, 50, 140};
        g.fillPolygon(xRoof, yRoof, 3);

        // SIENA COLLEGE sign
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Serif", Font.BOLD, 14));
        g.drawString("SIENA COLLEGE", 140, 110);

        // Cupola 
        g.setColor(Color.WHITE);
        g.fillRect(180, 25, 40, 40);
        g.fillArc(180, 5, 40, 40, 0, 180);

        // Window in Cupola 
        g.setColor(Color.LIGHT_GRAY);
        g.fillArc(190, 15, 20, 20, 0, 180);
        g.fillRect(190, 25, 20, 20);
        g.setColor(Color.BLACK);
        g.drawArc(190, 15, 20, 20, 0, 180);
        g.drawRect(190, 25, 20, 20);
        g.drawLine(200, 15, 200, 45);
        g.drawLine(190, 35, 210, 35);

        // Antenna
        g.drawLine(200, 5, 200, -10);
        g.fillOval(195, -15, 10, 10);

        // Windows 
        g.setColor(Color.WHITE);
        for (int i = 0; i < 4; i++) {
            g.fillRect(60 + (i * 75), 150, 55, 30);
            g.fillRect(60 + (i * 75), 190, 55, 30);
        }

        // Window Grids
        g.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            g.drawLine(87 + (i * 75), 150, 87 + (i * 75), 180);
            g.drawLine(60 + (i * 75), 165, 115 + (i * 75), 165);
            g.drawLine(87 + (i * 75), 190, 87 + (i * 75), 220);
            g.drawLine(60 + (i * 75), 205, 115 + (i * 75), 205);
        }

        // Door 
        g.setColor(new Color(139, 69, 19));
        g.fillRect(165, 230, 70, 50);

        // Door Grids
        g.setColor(Color.WHITE);
        g.drawLine(175, 230, 175, 280);
        g.drawLine(185, 230, 185, 280);
        g.drawLine(195, 230, 195, 280);
        g.drawLine(205, 230, 205, 280);

        // Stairs
        g.setColor(Color.GRAY);
        g.fillRect(155, 280, 90, 10); // First step
        g.fillRect(145, 290, 110, 10); // Second step
        g.setColor(Color.DARK_GRAY); // Outline for stairs
        g.drawRect(155, 280, 90, 10);
        g.drawRect(145, 290, 110, 10);
        

        // Outer Columns 
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(110 + (i * 150), 140, 30, 160);
            g.setColor(Color.WHITE);
            g.fillRect(105 + (i * 150), 140, 30, 160);
        }

        // Central Columns 
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(165 + (i * 50), 140, 30, 140); 
            g.setColor(Color.WHITE);
            g.fillRect(155 + (i * 50), 140, 30, 140);
        }

        // Grass 
        g.setColor(new Color(60, 179, 113));
        g.fillRect(0, 300, 400, 50);

        // Bushes 
        g.setColor(new Color(34, 139, 34));
        for (int i = 0; i < 8; i++) {
            g.fillOval(40 + (i * 40), 300, 50, 30);
        }

        // Road 
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 320, 400, 30); // Road

        // Yellow dashed line
        g.setColor(Color.YELLOW);
        for (int i = 0; i < 8; i++) {
            g.fillRect(30 + (i * 50), 332, 20, 5); 
        }

        // Car 
        g.setColor(Color.BLUE);
        g.fillRect(100, 300, 60, 20); // Car body
        g.fillRect(115, 290, 30, 15); // Car roof

        g.setColor(Color.WHITE);
        g.fillRect(117, 293, 10, 5); // window
        g.fillRect(130, 293, 10, 5); // window

        g.setColor(Color.BLACK);
        g.fillOval(105, 315, 15, 15); // Left wheel
        g.fillOval(140, 315, 15, 15); // Right wheel

        // Trees 
        g.setColor(new Color(101, 67, 33)); 
        // Left and right trunks
        for (int i = 0; i < 2; i++) {
            g.fillRect(20 + (i * 340), 250, 20, 50); 
        }

        // Green leaves
        g.setColor(new Color(34, 139, 34)); 
        // Left and right tree tops
        for (int i = 0; i < 2; i++) {
            g.fillOval(5 + (i * 340), 230, 50, 50); 
        }
    }    
}

public class ArtProject implements Runnable {
    
    // class variable
    public static JPanel panel;

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {
        
        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
