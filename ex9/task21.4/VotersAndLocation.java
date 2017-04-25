// Pairing of a voter to location of the vote
public class VotersAndLocation
{
  // Voter info
  private String voterInfo;

  // Location of the initial vote
  private String initialVoteLocation;

  // Create a pairing between a voter and location
  public VotersAndLocation(String voter, String location)
  {
    voterInfo = voter;
    initialVoteLocation = location;
  }

  // Print voters info and location of the initial vote
  public String toString()
  {
    return "First occurrence: " + initialVoteLocation;
  }
}
