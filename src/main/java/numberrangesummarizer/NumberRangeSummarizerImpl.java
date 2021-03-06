package numberrangesummarizer;

import java.util.Collection;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

  @Override
  public Collection<Integer> collect(String input){
    return NumberRange.convertStringOfNumbersToCollectionOfNumbers(input);
  }

  @Override
  public String summarizeCollection(Collection<Integer> input) {
    return NumberRange.convertCollectionOfNumbersToSummarizedCollection(input);
  }
}