// Calculates a min, max and mean of the array. Auto-boxing is not used.
public class IntArrayStats
{
  public static Triple<Integer, Integer, Double> getStats(int[] array)
                                          throws ArrayIndexOutOfBoundsException
  {
    // May throw an exception here, if no arguments provided
    int max = array[0];
    int min = array[0];

    // First number in the loop won't be taken into consideration, so sum
    // needs to be equel to at least first number in array
    int sum = array[0];

    for(int index = 1; index < array.length; index++)
    {
      if(array[index] > max)
        max = array[index];
      else if (array[index] < min)
        min = array[index];

      sum += array[index];
    }
    double mean = (double)sum / array.length;

    return new Triple<Integer, Integer, Double>(max, min, mean);
  }
}
