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

        // gets width and height from the panel
        widthPanel = HelloGraphics.panel.getWidth();
        heightPanel = HelloGraphics.panel.getHeight();

        // gets the font and creates a new one that has different style, name and size
        Font currentFont = g.getFont();
        Font newFont = new Font("Sitka Display", Font.BOLD, 54);	
        g.setFont(newFont);

        // creates two colors and sets the foreground and background with one of each colors
        Color colorFore = new Color(50, 100, 200);
        HelloGraphics.panel.setForeground(colorFore);
        Color colorBack = new Color(200, 100, 50);
        HelloGraphics.panel.setBackground(colorBack);

        // we get the width and the height of the String
        fontMetrics = g.getFontMetrics();
        widthFont = fontMetrics.stringWidth("Hello, Java Graphics World!");
        heightFont = fontMetrics.getAscent();

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        g.drawString("Hello, Java Graphics World!", widthPanel / 2 - widthFont / 2, heightPanel / 2 - heightFont / 2);
    }
}

public class HelloGraphics implements Runnable {
    
    // class variable
    public static JPanel panel;

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {
        
        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
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
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
