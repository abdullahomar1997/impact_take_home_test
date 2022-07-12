package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

  NumberRangeSummarizerImpl numberRangeSummarizer = new NumberRangeSummarizerImpl();

  @Test
  public void collect_ShouldReturnEmptyCollection_WhenInputIsNull(){

    String sampleInput = null;

    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = Collections.emptyList();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnEmptyCollection_WhenInputIsInvalid(){

    String sampleInput = "I,n,v,a,l,i,d";

    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = Collections.emptyList();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnEmptyCollection_WhenInputIsAnEmptyString(){

    String sampleInput = "";

    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = Collections.emptyList();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnCorrectCollection_WhenInputOnlyHasOneNumber(){

    String sampleInput = "1";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Collections.singletonList(1));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnCorrectCollection_WhenInputHasPositiveNumbers(){

    String sampleInput = "1,3,4,5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(1,3,4,5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnCorrectCollection_WhenInputHasNegativeNumbers(){

    String sampleInput = "-1,-3,-4,-5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(-1,-3,-4,-5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_ShouldReturnCorrectCollection_WhenInputHasPositiveAndNegativeNumbers(){

    String sampleInput = "1,3,-4,-5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(1,3,-4,-5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnAnEmptyString_WhenInputIsNull(){

    Collection<Integer> sampleInput = null;
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnAnEmptyString_WhenInputIsAnEmptyCollection(){

    Collection<Integer> sampleInput = Collections.emptyList();
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasNoSequentialNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,3,5,7,9));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1, 3, 5, 7, 9";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputOnlyHasOneNumber(){

    Collection<Integer> sampleInput = new ArrayList<>(Collections.singletonList(200));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "200";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasSequentialPositiveNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1, 3, 6-8, 12-15, 21-24, 31";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasSequentialNegativeNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(-9,-8,-6,-3,-1));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "-9--8, -6, -3, -1";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasAscendingSequentialNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(0,2,3,4,5,6,33,44,55));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "0, 2-6, 33, 44, 55";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasDescendingSequentialNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(55,44,33,2,1,0));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "55, 44, 33, 2-0";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasAscendingAndDescendingSequentialNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,2,3,5,4,3,1,3,4));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1-3, 5-3, 1, 3-4";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasSequentialNumbersAtTheBeginning(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(-6,-5,-4,-3,-2,-1,0,1,2,3,33,44,55));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "-6-3, 33, 44, 55";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasSequentialNumbersAtTheEnd(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(-9,-7,-5,-3,-2,-1));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "-9, -7, -5, -3--1";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasMultipleSequentialNumbers(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(100,101,102,-1,8,-7,-6,-5,88,65,1,2));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "100-102, -1, 8, -7--5, 88, 65, 1-2";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_ShouldReturnCorrectOutput_WhenInputHasConsecutiveNumbersThatAreTheSame(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,1,1,3,3,3,4,4,4));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1, 1, 1, 3, 3, 3-4, 4, 4";

    assertEquals(expectedValue,actualValue);

  }

}