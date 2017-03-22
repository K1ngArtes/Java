import java.awt.Color;

// Ball, which has 4 states: normal, invisible, flashing and counting
public class MagicBall extends Ball
{
  private final int NORMAL = 0;
  private final int INVISIBLE = 1;
  private final int FLASHING = 2;
  private final int COUNTING = 3;
  private int currentState;
  private int counter;
  private boolean isFlashing, isVisible;

  public MagicBall(int requiredValue, Color requiredColor)
  {
    super(requiredValue, requiredColor);
    counter = -1;
    currentState = NORMAL;
    isFlashing = false;
    isVisible = true;
  }

  @Override
  public BallImage makeImage()
  {
    return new MagicBallImage(this);
  }

  // Get the value of the ball
  @Override
  public int getValue()
  {
    if(currentState == COUNTING)
    {
      if(counter == 99)
        counter = 0;
      else
        counter++;
      return counter;
    }
    else
      return super.getValue();
  }

  public void doMagic(int spellNumber)
  {
    if(spellNumber == 1)
    {
      switch(currentState)
      {
        case NORMAL: makeInvisible(); break;
        case INVISIBLE: makeFlash(); break;
        case FLASHING: makeCounting(); break;
        case COUNTING: makeNormal(); break;
      }
    }
    else
      makeNormal();
  }

  public boolean isVisible()
  {
    return isVisible;
  }

  public boolean isFlashing()
  {
    return isFlashing;
  }

  // Returns a magic ball to normal state
  private void makeNormal()
  {
    currentState = NORMAL;
    isVisible = true;
    isFlashing = false;
    getImage().update();
  }

  // Makes ball invisible
  private void makeInvisible()
  {
    currentState = INVISIBLE;
    isFlashing = false;
    isVisible = false;
    getImage().update();
  }

  // Make ball flash non-stop
  private void makeFlash()
  {
    currentState = FLASHING;
    isFlashing = true;
    isVisible = true;
    getImage().update();
  }

  // Make ball flash and change the ball each time it flashes in range from
  // 0 to 99
  private void makeCounting()
  {
    currentState = COUNTING;
    getImage().update();
  }
}
