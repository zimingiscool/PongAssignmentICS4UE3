import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Draw extends JPanel
{
    @Override 
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set Cartesian plane origin to center of the panel
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Translate Graphics2D origin
        g2d.translate(centerX, centerY);
        g2d.scale(1, -1);  // Invert y-axis

        // Draw an axis
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawLine(-centerX, 0, centerX, 0); // X-axis
        g2d.drawLine(0, -centerY, 0, centerY); // Y-axis

        // Draw a shape at a specific Cartesian point
        g2d.setColor(Color.BLUE);
        int x = 100;  // x-coordinate
        int y = 50;   // y-coordinate
        g2d.fill(new Ellipse2D.Double(x - 5, y - 5, 10, 10));
    }   
}
