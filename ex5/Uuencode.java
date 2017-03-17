import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Program, which encodes binary file into ASCII code like uuencode command on
// Unix machines
public class Uuencode
{
  private static FileInputStream input;
  private static int[] lineBytes;
  private static int byteGroupIndex;

  public static void main(String[] args)
  {
    try
    {
      // Check if at least one argument is supplied
      if(args.length != 1)
        throw new IllegalArgumentException("One argument is required");

      input = new FileInputStream(args[0]);

      System.out.println("begin 600 " + args[0]);

      // 60 characters in original uuencode, so 60/4 * 3 = 45
      lineBytes = new int[45];

      int currentByte = input.read();
      while(currentByte != -1)
      {
        int arrayIndex = 0;

        while(currentByte != -1 && arrayIndex < lineBytes.length)
        {
          lineBytes[arrayIndex] = currentByte;
          currentByte = input.read();
          arrayIndex++;
        }
        // Now arrayIndex holds number of bytes in the line and points at
        // next position in the array after last byte

        // Print the number of bytes in the line
        writeByteAsChar(arrayIndex);

        // Number of bytes in the last line needs to be divisible by 3 for
        // succesfull conversion. If number of bytes is not divisible by 3
        // number of 0's is added to make it so
        if(arrayIndex < lineBytes.length)
        {
          if(arrayIndex % 3 == 1)
          {
            lineBytes[arrayIndex] = 0;
            lineBytes[arrayIndex + 1] = 0;
          }
          else if (arrayIndex % 3 == 2)
          {
            lineBytes[arrayIndex] = 0;
          }
        }

        for(byteGroupIndex = 0; byteGroupIndex < arrayIndex;
            byteGroupIndex += 3)
        {
          calculateFourBytes();
        }
        System.out.println();
      }
      System.out.println("`");
      System.out.println("end");
    }
    catch(IllegalArgumentException exception)
    {
      System.err.println(exception);
    }
    catch(IOException exception)
    {
      System.err.println("Problem reading the file: " + exception);
    }
    /*
    catch(FileNotFoundException exception)
    {
      System.err.println("Problem opening the file: " + args[0]);
    } */
    finally
    {
      try
      {
        if(input != null)
          input.close();
      }
      catch(IOException exception)
      {
        System.err.println("Could not close file " + exception);
      }
    }
  }

  // Write a single result byte as a printable character.
  // Each byte is 6-bit
  // Thus adding 32 makes it printable, except for 0 which would become space
  // and so we add 96 instead
  private static void writeByteAsChar(int thisByte)
  {
    System.out.print((char) (thisByte == 0 ? 96 : thisByte + 32));
  }

  // Calculate 4 result bytes from the 3 input bytes
  private static void calculateFourBytes()
  {
    int byte1 = lineBytes[byteGroupIndex] >> 2;
    int byte2 = (lineBytes[byteGroupIndex] & 0x3) << 4
                | (lineBytes[byteGroupIndex + 1] >> 4);
    int byte3 = (lineBytes[byteGroupIndex + 1] & 0xf) << 2
                | (lineBytes[byteGroupIndex + 2] >> 6);
    int byte4 = lineBytes[byteGroupIndex + 2] & 0x3f;

    writeByteAsChar(byte1);
    writeByteAsChar(byte2);
    writeByteAsChar(byte3);
    writeByteAsChar(byte4);
  }
}
