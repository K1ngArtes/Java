// This program tests MinMaxArray
public class TestMinMaxArray
{
  public static void main(String args[])
  {
    // Create a pair of min and max
    Pair minMaxPair = MinMaxArray.findMinMax(args);

    // Print the result
    for(int index = 0; index < args.length; index++)
    {
      System.out.print(args[index] + " ");
    }

    System.out.println();
    System.out.println("Min is " + minMaxPair.getFirst());
    System.out.println("Max is " + minMaxPair.getSecond());
  }

}
