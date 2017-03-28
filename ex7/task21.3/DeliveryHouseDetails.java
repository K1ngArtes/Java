// Provides information about houses and the way to compare them
public class DeliveryHouseDetails implements Comparable<DeliveryHouseDetails>
{
  private final int houseNumber;
  private String personName;

  public DeliveryHouseDetails(String numberAndName)
  {
    String[] lineWords = numberAndName.split(" ");

    // Save house number
    houseNumber = Integer.parseInt(lineWords[0]);

    personName = numberAndName;
  }

  // Accessor method for person name with number
  public String getPersonName()
  {
    return personName;
  }

  // Accessor method for number of the house
  public int getHouseNumber()
  {
    return houseNumber;
  }

  // Way of comparing houses
  public int compareTo(DeliveryHouseDetails otherHouse)
  {
    int otherHouseNumber = otherHouse.getHouseNumber();

    if(houseNumber % 2 == 1 && otherHouseNumber % 2 == 1)
    {
      return houseNumber - otherHouseNumber;
    }
    else if(houseNumber % 2 == 0 && otherHouseNumber % 2 == 0)
    {
      return otherHouseNumber - houseNumber;
    }
    else if(houseNumber % 2 == 1)
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }

  // Equivalences test, consistent with compareTo
  @Override
  public boolean equals(Object otherHouse)
  {
    if(otherHouse instanceof DeliveryHouseDetails)
    {
      return houseNumber == ((DeliveryHouseDetails)otherHouse).getHouseNumber();
    }
    else
    {
      return super.equals(otherHouse);
    }
  }
}
