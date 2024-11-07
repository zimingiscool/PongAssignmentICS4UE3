import java.awt.*;

public class Paddle {
    private int x, y, width, height;
    private int ySpeed; // Speed of the paddle movement in the Y direction
    private int screenHeight;
    private Color color;

    public Paddle(int startX, int startY, int width, int height, int screenHeight) {
        this.x = startX;
        this.y = startY;
        this.width = width;
        this.height = height;
        this.screenHeight = screenHeight;
        this.ySpeed = 0;
        this.color = Color.WHITE; // Paddle color
    }

    // Method to move the paddle based on its current speed
    public void move() {
        y += ySpeed;

        // Prevent paddle from moving out of bounds
        if (y < 0) {
            y = 0;
        } else if (y + height > screenHeight) {
            y = screenHeight - height;
        }
    }

    // Draw the paddle on the screen
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    // Set the paddle speed (for keyboard controls)
    public void setYSpeed(int speed) {
        this.ySpeed = speed;
    }

    // Check if the paddle collides with the ball
    public boolean checkCollision(Ball ball) {
        int ballX = ball.getX();
        int ballY = ball.getY();
        int ballWidth = ball.getWidth();

        // Simple AABB (Axis-Aligned Bounding Box) collision detection
        return (ballX + ballWidth >= x && ballX <= x + width &&
                ballY + ballWidth >= y && ballY <= y + height);
    }
}
