import java.awt.*; // For Graphics, Color, and Dimension
import java.awt.event.*; // For ActionListener, KeyListener
import javax.swing.*;

public class App extends JPanel implements ActionListener, KeyListener {
    private static final int paddlePadding = 30; // Distance from edge for paddles

    private Ball ball; // The ball object
    private Paddle paddle; // Player 1 paddle
    private Paddle paddle2; // Player 2 paddle

    private Player player1; // Player 1
    private Player player2; // Player 2

    private JLabel p1Score; // Player 1 Score Label
    private JLabel p2Score; // Player 2 Score Label

    public App() {
        // Initialize players
        this.player1 = new Player("drippy cheese");
        this.player2 = new Player("american breakfast");

        // Initialize ball and paddles
        ball = new Ball(300, 200, player1, player2); // Ball starts at center (default)
        paddle = new Paddle(paddlePadding, 200 - 30, 10, 60, getHeight()); // Player 1 paddle
        paddle2 = new Paddle(600 - paddlePadding - 10, 200 - 30, 10, 60, getHeight()); // Player 2 paddle

        // Panel settings
        setBackground(Color.BLACK);
        Timer timer = new Timer(1000 / 60, this); // Game loop runs at 60 FPS
        timer.start();

        setFocusable(true); // Panel can receive keyboard events
        addKeyListener(this); // Add keyboard controls
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move(getWidth(), getHeight()); // Move the ball dynamically
        paddle.move(getHeight()); // Use panel height for paddle bounds
        paddle2.move(getHeight()); // Use panel height for paddle bounds

        // Check for collision between the ball and paddles
        if (paddle.checkCollision(ball)) {
            ball.setSpeed(-ball.getXSpeed(), ball.getYSpeed()); // Reverse ball's horizontal direction
        }
        if (paddle2.checkCollision(ball)) {
            ball.setSpeed(-ball.getXSpeed(), ball.getYSpeed()); // Reverse ball's horizontal direction
        }

        // Update score labels
        p1Score.setText(player1.getName() + ": " + player1.getPoints());
        p2Score.setText(player2.getName() + ": " + player2.getPoints());

        repaint(); // Redraw the game screen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g); // Draw the ball
        paddle.draw(g); // Draw Player 1's paddle
        paddle2.draw(g); // Draw Player 2's paddle
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Player 1 controls (W/S keys)
        if (key == KeyEvent.VK_W) {
            paddle.setYSpeed(-5); // Move paddle up
        } else if (key == KeyEvent.VK_S) {
            paddle.setYSpeed(5); // Move paddle down
        }
        // Player 2 controls (UP/DOWN arrow keys)
        if (key == KeyEvent.VK_UP) {
            paddle2.setYSpeed(-5); // Move paddle up
        } else if (key == KeyEvent.VK_DOWN) {
            paddle2.setYSpeed(5); // Move paddle down
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // Stop paddle movement on key release
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
            paddle.setYSpeed(0);
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            paddle2.setYSpeed(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed for keyTyped
    }

    public static void main(String[] args) {
        // Create JFrame for the game
        JFrame frame = new JFrame("Pong Game");
        App pongGame = new App();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Set the window size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for proper positioning
        frame.add(pongGame, BorderLayout.CENTER); // Add the game panel to the center

        // Create Score Labels
        pongGame.p1Score = new JLabel(pongGame.player1.getName() + ": " + pongGame.player1.getPoints());
        pongGame.p2Score = new JLabel(pongGame.player2.getName() + ": " + pongGame.player2.getPoints());
        pongGame.p1Score.setForeground(Color.WHITE);
        pongGame.p2Score.setForeground(Color.WHITE);
        pongGame.p1Score.setHorizontalAlignment(SwingConstants.LEFT);
        pongGame.p2Score.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.setBackground(Color.BLACK);
        scorePanel.add(pongGame.p1Score, BorderLayout.WEST);
        scorePanel.add(pongGame.p2Score, BorderLayout.EAST);

        frame.add(scorePanel, BorderLayout.NORTH); // Add score panel to the top

        // Start the game
        frame.setVisible(true);
    }
}
