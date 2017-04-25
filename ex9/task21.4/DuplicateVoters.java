import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

// Finds and reports duplicate voters
public class DuplicateVoters
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      VotersAndLocation voterAndLocation = null;

      if(args.length != 2)
      {
        throw new IllegalArgumentException("Please, supply two arguments");
      }

      // Create input and Output
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(args[1]);

      // Map for storing all votings
      HashMap<String, VotersAndLocation> votingHashMap =
                                       new HashMap<String, VotersAndLocation>();

      // Read lines from text file and check, if duplicate has been found
      String currentLine;
      int numberOfDuplicates = 0;
      while((currentLine = input.readLine()) != null)
      {
        // Try to add a voter to the map. If he is already there, then
        // the duplicate has been foun, else add the voter to the map
        if(votingHashMap.get(currentLine) == null)
        {
          System.out.println(currentLine);

          // Create new link between voter and location
          voterAndLocation =
                           new VotersAndLocation(currentLine, input.readLine());
          // Add the voter to the map
          votingHashMap.put(currentLine, voterAndLocation);
        }
        else
        {
          // Print voter
          output.println(currentLine);
          // Print the location of duplicate vote
          output.println("Duplicate vote: " + input.readLine());
          // Print the initial vote location
          output.println(voterAndLocation);

          numberOfDuplicates++;
        }
      }

      // Write the number of duplicates to the file
      output.println("There were " + numberOfDuplicates + " duplicate votes");
    }
    catch(IllegalArgumentException e)
    {
      System.err.println(e);
    }
    catch(IOException e)
    {
      System.err.println(e);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
    finally
    {
      try
      {
        if (input != null)
          input.close();
      }
      catch(IOException e)
      {
        System.err.println("Can't close output " + e);
      }
      if(output != null)
      {
        output.close();
        if(output.checkError())
          System.err.println("Something went wrong with output");
      }
    }
  }
}
