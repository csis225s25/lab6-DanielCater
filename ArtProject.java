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

        // creates two colors and sets the foreground and background with one of each colors
        Color colorFore = new Color(50, 100, 200);
        ArtProject.panel.setForeground(colorFore);
        Color colorBack = new Color(200, 100, 50);
        ArtProject.panel.setBackground(colorBack);
        
        g.drawOval(30, 50, 10, 20); // drawOval(int x, int y, int width, int height)
        g.drawArc(); //(int x, int y, int width, int height, int startAngle, int arcAngle)
        g.drawLine(); // drawLine(int x1, int y1, int x2, int y2)dr
        g.drawPolygon() // drawPolygon(int[] xPoints, int[] yPoints, int nPoints) or drawPolygon(Polygon p)
        g.drawRect(); // drawRect(int x, int y, int width, int height)
        g.fillArc(); // fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
        g.fillOval(); // fillOval(int x, int y, int width, int height)
        g.fillPolygon(); //	fillPolygon(int[] xPoints, int[] yPoints, int nPoints) // fillPolygon(Polygon p)
        g.fillRect(); // fillRect(int x, int y, int width, int height)

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
