// Represents a machine, which flashes all the balls before ejected one
public class DramaticMachine extends Machine
{
  public DramaticMachine(String name, int size)
  {
    super(name, size);
  }

  // Return the type of the BallContainer
  @Override
  public String getType()
  {
    return "Dramatic Machine";
  }

  // Choose ball at random, flash all balls before it and eject it
  @Override
  public Ball ejectBall()
  {
    if(getNoOfBalls() <= 0)
      return null;
    else
    {
      // Randomly choose a ball
      int ejectedBallIndex = (int) (Math.random() * getNoOfBalls());

      Ball ejectedBall = getBall(ejectedBallIndex);

      // Flash all the balls before the chosen one
      for(int precedingBallsIndex = 0; precedingBallsIndex < ejectedBallIndex;
          precedingBallsIndex++)
        {
          getBall(precedingBallsIndex).flash(4, 10);
        }

        // Flash chosen ball
        ejectedBall.flash(4, 5);
        // Eject ball
        swapBalls(ejectedBallIndex, getNoOfBalls() - 1);
        removeBall();

        return ejectedBall;
    }
  }
}
