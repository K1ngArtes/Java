// The Objects grouped into a pair
public class Pair<FirstType, SecondType>
{
  // The first object
  private final FirstType first;
  //The second object
  private final SecondType second;

  // Constructor is given two objects
  public Pair(FirstType requiredFirst, SecondType requiredSecond)
  {
    first = requiredFirst;
    second = requiredSecond;
  }

  // Return the first object
  public FirstType getFirst()
  {
    return first;
  }

  // Return second object
  public SecondType getSecond()
  {
    return second;
  }
}
