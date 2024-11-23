import java.awt.*; // For JFrame, JPanel, and Timer
import java.awt.event.*; // For Graphics, Color, and Dimension
import javax.swing.*;

public class App extends JPanel implements ActionListener, KeyListener {
  private static final int screenWidth = 600;
  private static final int screenHeight = 400;

  private static final int paddlePadding = 30;

  private Ball ball;
  private Paddle paddle;
  private Paddle paddle2;

  private Player player1;
  private Player player2;

  public App() {
    this.player1 = new Player("drippy cheese");
    this.player2 = new Player("american breakfast");

    ball = new Ball(screenWidth / 2, screenHeight / 2, player1, player2); // Initialize ball at starting position (x, y)
                                                                          // and size
    paddle = new Paddle(paddlePadding, 150, 10, 60, screenHeight - 30);
    paddle2 = new Paddle((screenWidth - paddlePadding), 150, 10, 60, (screenHeight - 30));

    setBackground(Color.BLACK); // Set the background color of the panel to black
    Timer timer = new Timer(1000 / 60, this); // Set up game loop at 60 FPS
    timer.start();

    setFocusable(true); // Allow the panel to receive key events
    addKeyListener(this); // Add key listener for paddle movement
  }

  // Collision
  @Override
  public void actionPerformed(ActionEvent e) {
    ball.move(getWidth(), getHeight()); // Move ball inside the panel
    paddle.move(); // Move the paddle based on current speed
    paddle2.move();

    // Check for collision between the ball and the paddle
    if (paddle.checkCollision(ball)) {
      ball.setSpeed(-ball.getXSpeed(), ball.getYSpeed()); // Reverse ball direction on collision
    }

    // Check for collision between the ball and the paddle 2
    if (paddle2.checkCollision(ball)) {
      ball.setSpeed(-ball.getXSpeed(), ball.getYSpeed()); // Reverse ball direction on collision
    }

    repaint(); // Repaint the panel
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    ball.draw(g); // Draw the ball on the panel
    paddle.draw(g);
    paddle2.draw(g);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
      paddle.move();
      paddle.setYSpeed(0); // Stop paddle when key is released
    }

    if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
      paddle2.move();
      paddle2.setYSpeed(0); // Stop paddle when key is released
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_W) {
      paddle.setYSpeed(-5); // Move paddle up
    } else if (key == KeyEvent.VK_S) {
      paddle.setYSpeed(5); // Move paddle down
    }

    if (key == KeyEvent.VK_UP) {
      paddle2.setYSpeed(-5); // Move paddle up
    } else if (key == KeyEvent.VK_DOWN) {
      paddle2.setYSpeed(5); // Move paddle down
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Pong Game");
    App pongGame = new App();
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(screenWidth, screenHeight); // Set window size
    frame.add(pongGame);
    frame.setVisible(true);
  }
}
