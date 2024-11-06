import java.awt.*;

public class Ball {
    private int x, y, xSpeed, ySpeed;
    private int diameter;
    private Color color;

    Ball(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.diameter = 5;
        this.xSpeed = 2;  // Horizontal speed
        this.ySpeed = 2;  // Vertical speed
        this.color = Color.WHITE; // Default color
    }

        // Move the ball and check for wall collisions
    public void move(int screenWidth, int screenHeight) {
        // Move the ball
        x += xSpeed;
        y += ySpeed;

        // Check for collision with the left and right walls
        if (x <= 0 || x + diameter >= screenWidth) {
            xSpeed = -xSpeed; // Reverse horizontal direction
        }

        // Check for collision with the top and bottom walls
        if (y <= 0 || y + diameter >= screenHeight) {
            ySpeed = -ySpeed; // Reverse vertical direction
        }
    }

    // Draw the ball on the screen
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter); // Draw the ball as a filled circle
    }
}
