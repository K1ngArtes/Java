import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

// Representation of the worker, who fills a machine with magic balls
public class MagicWorker extends Worker
{
  private List<MagicBall> ballsMade = new ArrayList<MagicBall>();

  // Constructor is given the person's name.
  public MagicWorker(String name)
  {
    super(name);
  }  // Worker

  @Override
  public MagicWorkerImage makeImage()
  {
    return new MagicWorkerImage(this);
  }

  // Returns the name of the type of Person.
  @Override
  public String getPersonType()
  {
    return "Magic Worker";
  } // getPersonType


  // Returns the Person's colour.
  public Color getColour()
  {
    return Color.lightGray;
  } // getColour


  // Returns a newly created Ball with the given number and colour.
  @Override
  public Ball makeNewBall(int number, Color colour)
  {
    MagicBall newMagicBall = new MagicBall(number, colour);
    ballsMade.add(newMagicBall);
    return newMagicBall;
  } // makeNewBall

  public void doMagic(int spellNumber)
  {
    for(int index = 0; index < ballsMade.size(); index++)
      ballsMade.get(index).doMagic(spellNumber);
  }

  // Makes this Worker fill the given machine of the given Game.
  // The Balls are created as they are inserted into the Machine.
  public void fillMachine(Game game)
  {
    // Colours of balls are evenly spread between these colours,
    // in ascending order.
    Color [] colourGroupColours
      = new Color [] {Color.red, Color.orange, Color.yellow,
                      Color.green, Color.blue, Color.pink,
                      Color.magenta};
    // This happiness change will show up when the GUI is added.
    setHappy(false);
    speak();
    Color ballColour;
    int noOfBalls = game.getMachineSize();
    for (int count = 1; count <= noOfBalls; count++)
    {
      // The colour group is a number from 0
      // to the number of colour groups - 1.
      // For the nth ball, we take the fraction
      // (n - 1) divided by the number of balls
      // and multiply that by the number of groups.
      int colourGroup = (int) ((count - 1.0) / (double) noOfBalls
                               * (double) colourGroupColours.length);
      ballColour = colourGroupColours[colourGroup];
      game.machineAddBall(makeNewBall(count, ballColour));
    } // for
    setHappy(true);
    speak();
  } // fillMachine

  // Return a representation of the class hierarchy of the person
  @Override
  public String getClassHierarchy()
  {
    return "Magic Worker>" + super.getClassHierarchy();
  }

} // class Worker
