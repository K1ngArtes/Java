import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

// This program takes lines from standard input or file and outputs this line
// into standard output or file without string at specified location
public class DeleteField
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    // By default it deletes first field
    int fieldToDelete = 1;

    try
    {
      // Check what field is required to be deleted. This is minimum required.
      if(args.length < 1)
        throw new DeleteFieldException("Field to delete is required");
      else if(args.length < 2)
        fieldToDelete = Integer.parseInt(args[0]);
      else if(args.length < 3)
        fieldToDelete = Integer.parseInt(args[1]);
      else
        fieldToDelete = Integer.parseInt(args[2]);

      // Check if user wants to input from standard input
      if(args.length < 2 || args[0].equals("-"))
        input = new BufferedReader(new InputStreamReader(System.in));
      else
        input = new BufferedReader(new FileReader(args[0]));

      // Check if user wants to output to standard output
      if(args.length < 3 || args[1].equals("-"))
        output = new PrintWriter(System.out, true);
      else
      {
        // Check if file already exists
        if(new File(args[1]).exists())
          throw new DeleteFieldException("Output file: " + args[1]
                                        + " already exists");

        output = new PrintWriter(new FileWriter(args[1]));
      }

      //Divide the line into fields using tab as a delimeter
      String currentLine;
      String[] fields;
      String editedLine = "";
      while((currentLine = input.readLine()) != null)
      {
        editedLine = "";
        fields = currentLine.split("\t");
        // If field to delete is bigger than the size of the array, no field
        // required to be deleted
        if(fields.length < fieldToDelete)
          editedLine = currentLine;
        else
        {
          for(int index = 0; index < fieldToDelete - 1; index++)
            editedLine += fields[index] + "\t";

          for(int index = fieldToDelete; index < fields.length; index++)
            editedLine += fields[index] + "\t";
        }
        output.println(editedLine);
      }
    }

    catch(DeleteFieldException exception)
    {
      System.err.println(exception);
    }
    catch(IOException exception)
    {
      System.err.println(exception);
    }
    catch(NumberFormatException exception)
    {
      System.err.println(exception);
    }
    finally
    {
      // Try to close the input
      try
      {
        if(input != null)
          input.close();
      }
      catch(IOException exception)
      {
        System.err.println("Could not close " + exception);
      }
      // Try to close the output
      if(output != null)
      {
        output.close();
        if(output.checkError())
          System.err.println("Something gone wrong with the output!");
      }
    }
  }
}
