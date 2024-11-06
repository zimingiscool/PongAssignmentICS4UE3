import javax.swing.*;

public class App extends JPanel implements ActionListener {

      public PongGame() {
        ball = new Ball(300, 200, 20); // Initialize ball at starting position (x, y) and size
        Timer timer = new Timer(1000 / 60, this); // Set up game loop at 60 FPS
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move(getWidth(), getHeight()); // Move ball inside the panel
        repaint(); // Repaint the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g); // Draw the ball on the panel
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        App pongGame = new App();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Set window size
        frame.add(pongGame);
        frame.setVisible(true);
    }

  public static void main(String[] args) {
    // Window Creation Code
    JFrame gameWindow = new JFrame("Window");
    gameWindow.setSize(512, 512);
    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create Panel
    Draw panel = new Draw();
    gameWindow.getContentPane().setBackground(Color.BLACK);


    //Set Styling
    gameWindow.add(panel);
    gameWindow.setVisible(true);
  }
}
