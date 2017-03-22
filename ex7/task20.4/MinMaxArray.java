// Calculates min and max of the array and creates an array out of it
public class MinMaxArray
{
  // Empty constructor
  public MinMaxArray()
  {}

  // Does the main work
  public static <ArrayType extends Comparable<ArrayType>> Pair<ArrayType, ArrayType> findMinMax(ArrayType[] array) throws IllegalArgumentException
  {
    // Check if array is valid
    if(array == null)
      throw new IllegalArgumentException("Array has to exist!");

    if(array.length == 0)
      throw new IllegalArgumentException("Supply some arguments!");

    // Find max and minimum
    ArrayType max = array[0];
    ArrayType min = array[0];

    for(int index = 0; index < array.length; index++)
    {
      if(array[index].compareTo(max) > 0)
        max = array[index];
      else if(array[index].compareTo(min) < 0)
        min = array[index];
    }

    // Create a pair out of min and max and return it
    return new Pair<ArrayType, ArrayType>(min, max);
  }
}
