// Tests groups of moody persons
public class TestMoodyGroup
{

  public static void main(String[] args)
  {
    MoodyGroup<Teenager> moodyGroup = new MoodyGroup<Teenager>();

    Teenager teenager = new Teenager("Teen 1");
    // Populate group with people
    moodyGroup.addPerson(teenager);
    moodyGroup.addPerson(new Teenager("Teen 2"));
    moodyGroup.addPerson(new Teenager("Teen 3"));
    moodyGroup.addPerson(new Teenager("Teen 4"));

    // Set happy to false and print the group
    for(int count = 1; count <= moodyGroup; count++)
    {
      moodyGroup.setHappy(false);
      System.out.printf("%s%n%n", moodyGroup);
    }

    // Set happy to true and print the group
    for(int count = 1; count <= moodyGroup; count++)
    {
      moodyGroup.setHappy(true);
      System.out.printf("%s%n%n", moodyGroup);
    }

    MoodyGroup moodyGroup2 = new MoodyGroup();
    moodyGroup2.addPerson(new Worker("Worker 2"));
    moodyGroup2.addPerson(teenager);

    // Set happy to false (2nd group) and print the group
    for(int count = 1; count <= moodyGroup; count++)
    {
      moodyGroup.setHappy(false);
      System.out.printf("%s%n%n", moodyGroup);
    }

    // Set happy to true (2nd group) and print the group
    for(int count = 1; count <= moodyGroup; count++)
    {
      moodyGroup.setHappy(true);
      System.out.printf("%s%n%n", moodyGroup);
    }
  }
}
