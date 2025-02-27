import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Creates a window that counts the number of times a mouse is pressed.
 * There is also a reset button to reset the counter.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Daniel Cater & Alejandro Perez Jorda
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener  {
	private String toDisplay; // String to be displayed
    private int count; //number of times mouse is pressed
    private JPanel panel;//panel being updated with the mouse counter
    private JButton reset;//reset button to reset counter

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Mouse press count: ";
				int stringWidth = fm.stringWidth(toDisplay + count);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay + count, xStart, yStart);
                
			}
		};

        // creates panel hierachy to have counter in the top center, and
        // reset button at the bottom.
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel();
        reset = new JButton("Reset");
		frame.add(panel2);
        panel2.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.SOUTH);
        panel3.add(reset);
		panel.addMouseListener(this);
        reset.addActionListener(this);


		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    /**
     * When a mouse is pressed, the counter goes up and the 
     * display is updated.
     * 
     * @param e The mouse event occuring.
     */
	@Override
	public void mousePressed(MouseEvent e) {
		count++;
        panel.repaint();
        
	}

    /**
     * When the reset button is pressed, the display is updated 
     * so the count is 0.
     * 
     * @param e The action occuring to reset.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == reset){
            count = 0;
            panel.repaint();
        }
        
    }


	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}

