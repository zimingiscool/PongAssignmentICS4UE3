import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class App 
{
    public static void main(String[] args) 
    {
        //Window Creation Code
        JFrame gameWindow = new JFrame("Window");
        gameWindow.setSize(512,512);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create Panel 
        Draw panel = new Draw();
        gameWindow.add(panel);

        gameWindow.setVisible(true);
    }
}
