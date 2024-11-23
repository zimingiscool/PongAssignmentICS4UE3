import java.awt.*;

public class Ball {
    private static int width = 20; // Ball width
    private int x, y, xSpeed, ySpeed; // Ball position and speed
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
    x += xSpeed;
    y += ySpeed;

    // Check for collision with the left wall
    if (x <= 0) {
        p2.addPoint(); // Player 2 scores
        resetBall(screenWidth, screenHeight); // Reset ball
    }
    // Check for collision with the right wall
    else if (x + width >= screenWidth) {
        p1.addPoint(); // Player 1 scores
        resetBall(screenWidth, screenHeight); // Reset ball
    }

    // Check for collision with the top and bottom walls
    if (y <= 0 || y + width >= screenHeight) {
        ySpeed = -ySpeed; // Reverse vertical direction
    }
}


    // Reset the ball to the center of the screen
    private void resetBall(int screenWidth, int screenHeight) {
        x = (screenWidth - width) / 2; // Center horizontally
        y = (screenHeight - width) / 2; // Center vertically
        xSpeed = -xSpeed; // Reverse horizontal direction for variety
    }

    // Reset the game (reset player points)
    private void resetGame() {
        p1.resetPoint();// Reset Player 1
        p2.resetPoint();; // Reset Player 2
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    // Set the ball's speed (optional)
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
        g.fillRect(x, y, width, width); // Draw the ball as a filled rectangle
    }
}
