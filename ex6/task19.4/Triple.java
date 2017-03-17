// Creates a triple from three objects
public class Triple<FirstType, SecondType, ThirdType>
{
  private final FirstType first;
  private final SecondType second;
  private final ThirdType third;

  public Triple(FirstType firstObj, SecondType secondObj, ThirdType thirdObj)
  {
    first = firstObj;
    second = secondObj;
    third = thirdObj;
  }

  // Return first object of the triple
  public FirstType getFirst()
  {
    return first;
  }

  // Return second object of the triple
  public SecondType getSecond()
  {
    return second;
  }

  // Return third object of the triple
  public ThirdType getThird()
  {
    return third;
  }
}
