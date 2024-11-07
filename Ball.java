import java.awt.*;
import javax.swing.JOptionPane;

public class Ball {
    private static int width = 20;
    private int x, y, xSpeed, ySpeed;
    private Color color;

    private Player p1;
    private Player p2;
    
    public Ball(int startX, int startY, Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.x = startX;
        this.y = startY;
        this.xSpeed = 2; // Horizontal speed
        this.ySpeed = 2; // Vertical speed
        this.color = Color.WHITE; // Default color
    }

    // Move the ball and check for wall collisions
    public void move(int screenWidth, int screenHeight) {
        // Move the ball
        x += xSpeed;
        y += ySpeed;

        // Check for collision with the left and right walls
        if (x <= 0) {
            // player 1 win
            this.p1.addPoint();
            JOptionPane.showMessageDialog(null, "Player: " + p1.getName() + " points: " + p1.getPoints());            x = 0; // Keep within the left boundary
            xSpeed = -xSpeed; // Reverse horizontal direction on left wall collision
        } else if (x + width >= screenWidth) {
            // player 2 win
            this.p2.addPoint();
            JOptionPane.showMessageDialog(null, "Player: " + p2.getName() + " points: " + p2.getPoints());
            
            x = screenWidth - width; // Keep within the right boundary
            xSpeed = -xSpeed; // Reverse horizontal direction on right wall collision
        }

        // Check for collision with the top and bottom walls
        if (y <= 0 || y + width >= screenHeight) {
            ySpeed = -ySpeed; // Reverse vertical direction
        }
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    // Setters for the ball's speed (optional)
    public void setSpeed(int xSpeed, int ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    // Draw the ball on the screen
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, width); // Draw the ball as a filled circle
    }
}
