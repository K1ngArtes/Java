import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

// Orders a list of houses to make them easy for delivery. It assumes that
// lines are ordered in ascending order by number on front
public class StreetOrder
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;

    try
    {
      if(args.length != 2)
      {
        throw new IllegalArgumentException("Please, supply two arguments");
      }
      // if(!args[0].exists())
      // {
      //   throw new FileNotFoundException("Input file doesnt exist!");
      // }
      // if(!args[1].canWrite())
      // {
      //   throw new IOException("Output file is not writable");
      // }

      // Create input and Output
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(args[1]);
      
      // List for storing hose number with names
      List<String> houseList = new ArrayList<String>();

      // Read lines from text file
      String currentLine;
      while((currentLine = input.readLine()) != null)
      {
        houseList.add(currentLine);
      }

      // Output all odd numbers
      String[] lineWords;
      for(int index = 0; index < houseList.size(); index++)
      {
        lineWords = houseList.get(index).split(" ");
        // May throw exception here
        if(Integer.parseInt(lineWords[0]) % 2 != 0)
        {
          output.println(houseList.get(index) + "\n");
        }
      }

      // Output all even numbers in reverse
      for(int index = houseList.size() - 1; index >= 0; index--)
      {
        lineWords = houseList.get(index).split(" ");
        // May throw exception here
        if(Integer.parseInt(lineWords[0]) % 2 == 0)
        {
          output.println(houseList.get(index) + "\n");
        }
      }
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
