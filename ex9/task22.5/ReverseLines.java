import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

// Print input lines in reverse order
public class ReverseLines
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(System.out);
      reverseText(input, output);
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

  // Recursive method that reverses the input text
  private static void reverseText(BufferedReader input, PrintWriter output)
                                                              throws IOException
  {
    String currentLine;
    String recursiveMethodTextLine;
    // Base case
    if((currentLine = input.readLine()) == null)
    {
      return;
    }
    else
    {
      recursiveMethodTextLine = currentLine;
      reverseText(input, output);
      output.println(recursiveMethodTextLine);
    }
  }
}
