// Prints all combinations from supplied characters
public class Anagrams
{
  private static char[] charArray;
  private static char[] currentPermutation;
  private static boolean[] wasThisCharacterUsed;

  public static void main(String args[])
  {
    charArray = args[0].toCharArray();
    currentPermutation = new char[charArray.length];
    wasThisCharacterUsed = new boolean[charArray.length];

    printPermutations(0);
  }

  private static void printPermutations(int currentIndex)
  {
    if(currentIndex == charArray.length)
    {
      String result = "";
      for(char character : currentPermutation)
      {
        result += character;
      }
      System.out.println(result);
    }
    else
    {
      for(int charIndex = 0; charIndex < charArray.length; charIndex++)
      {
        // System.out.println(wasThisCharacterUsed[charIndex]);
        if(!wasThisCharacterUsed[charIndex])
        {
          wasThisCharacterUsed[charIndex] = true;
          currentPermutation[currentIndex] = charArray[charIndex];
          printPermutations(currentIndex + 1);
          wasThisCharacterUsed[charIndex] = false;
        }
      }
    }
  }
}
