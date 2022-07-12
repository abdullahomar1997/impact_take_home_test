package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRange {

  public NumberRange() {
  }

  public static Collection<Integer> convertStringOfNumbersToCollectionOfNumbers(String input){

    if(input.equals("")) return Collections.emptyList();

    //Ideally would have thrown an exception or error Message for an Invalid Input
    if(!input.matches("[-0-9]+(,[-0-9]+)*")) return Collections.emptyList();

    return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
  }

  public static String convertCollectionOfNumbersToSummarizedCollection(Collection<Integer> input) {

    if(input.size() == 0) return "";

    List<Integer> inputAsList = new ArrayList<>(input);

    List<String> listOfSequentialNumbers = new ArrayList<>();

    int previousNumber = input.iterator().next();

    int fromIndex = 0;
    int toIndex = 0;

    for (Integer number : input) {

      if (toIndex != 0 && isNonSequential(previousNumber, number)) {
        listOfSequentialNumbers.add(groupIntoRange(inputAsList.subList(fromIndex, toIndex)));
        fromIndex = toIndex;
      }

      if (toIndex == input.size() - 1) {
        listOfSequentialNumbers.add(groupIntoRange(inputAsList.subList(fromIndex, toIndex += 1)));
      }

      previousNumber = number;
      toIndex++;
    }

    return String.join(", ", listOfSequentialNumbers);
  }

  public static String groupIntoRange(List<Integer> input) {

    if(input.size() == 1) return input.get(0).toString();

    return input.get(0) + "-" + input.get(input.size() - 1);
  }

  private static boolean isNonSequential(int previousNumber, Integer number) {
    return number <= previousNumber && number != previousNumber - 1 || number >= previousNumber && number != previousNumber + 1;
  }
}