// Representation of the moody group of persons
public class MoodyGroup<PersonType extends MoodyPerson>
{
  private final int INITIAL_ARRAY_SIZE = 2, ARRAY_RESIZE_FACTOR = 2;

  private MoodyPerson[] moodyPersons = new MoodyPerson[INITIAL_ARRAY_SIZE];
  private int noOfPersons = 0;

  // Empty constructor just for it to be
  public MoodyGroup()
  {
  }

  // Add a person to moodyPersons
  public int addPerson(PersonType newPerson)
  {
    if(noOfPersons == moodyPersons.length)
      createBiggerArray();
    moodyPersons[noOfPersons] = newPerson;
    noOfPersons++;
  }

  // Create a bigger array for moodyPersons
  private int createBiggerArray()
  {
    MoodyPerson[] biggerArray = new MoodyPerson[moodyPersons.length
                                              * ARRAY_RESIZE_FACTOR];
    for(int index = 0; index < moodyPersons.length; index++)
      biggerArray[index] = moodyPersons[index];
    moodyPersons = biggerArray;
  }

  // Return number of persons in the conversation
  public int getSize()
  {
    return noOfPersons;
  }

  private int nextToChangeMood = 0;
  // Make the next person in array happy or not
  public void isHappy(boolean isHappy)
  {
    if(noOfPersons > 0)
    {
      moodyPersons[nextToChangeMood].setHappy(isHappy);
      nextToChangeMood = (nextToChangeMood + 1) % noOfPersons;
    }
  }

  // Print the moody group
  @Override
  public String toString()
  {
    String result = noOfPersons == 0 ? "" : "" + moodyPersons[0];
    for(int index = 1; index < moodyPersons.length; index++)
      result += String.format("%n%s", moodyPersons[index]);
    return result;
  }
}
