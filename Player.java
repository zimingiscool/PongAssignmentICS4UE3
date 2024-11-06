public class Player 
{
  private String name = "";
  private int points = 0;

  public Player(String name) 
  {
    this.name = name;
  }

  public int getPoints()
  {
    return this.points;
  }

  public void addPoint()
  {
    points++;
  }
}
