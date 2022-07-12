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
  public void collect_testInvalidInputReturnsEmptyCollection(){

    String sampleInput = "I,n,v,a,l,i,d";

    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = Collections.emptyList();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_testEmptyStringInputReturnsEmptyCollection(){

    String sampleInput = "";

    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = Collections.emptyList();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_testValidInputWithOneNumberReturnsCorrectCollection(){

    String sampleInput = "1";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(1));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_testValidInputWithPositiveNumbersReturnsCorrectCollection(){

    String sampleInput = "1,3,4,5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(1,3,4,5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_testValidInputWithNegativeNumbersReturnsCorrectCollection(){

    String sampleInput = "-1,-3,-4,-5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(-1,-3,-4,-5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void collect_testValidInputWithPositiveAndNegativeNumbersReturnsCorrectCollection(){

    String sampleInput = "1,3,-4,-5";
    Collection<Integer> actualValue = numberRangeSummarizer.collect(sampleInput);
    Collection<Integer> expectedValue = new ArrayList<>(Arrays.asList(1,3,-4,-5));

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void summarizeCollection_testEmptyCollectionInputReturnsEmptyStringOutput(){

    Collection<Integer> sampleInput = Collections.emptyList();
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_testInputWithNoSequentialNumbersReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,3,5,7,9));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1, 3, 5, 7, 9";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_testInputWithAscendingSequentialNumbersReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(0,2,3,4,5,6,33,44,55));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "0, 2-6, 33, 44, 55";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_testInputWithDescendingSequentialNumbersReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(55,44,33,2,1,0));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "55, 44, 33, 2-0";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_testInputWithSequentialNumbersAtTheBeginningReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(-6,-5,-4,-3,-2,-1,0,1,2,3,33,44,55));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "-6-3, 33, 44, 55";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_testInputWithSequentialNumbersAtTheEndReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(-9,-7,-5,-3,-2,-1));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "-9, -7, -5, -3--1";

    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void summarizeCollection_testInputWithMultipleSequentialNumbersReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(100,101,102,-1,8,-7,-6,-5,88,65,1,2));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "100-102, -1, 8, -7--5, 88, 65, 1-2";

    assertEquals(expectedValue,actualValue);

  }

  @Test
  public void summarizeCollection_testInputWithTwoConsecutiveSameNumbersReturnsCorrectOutput(){

    Collection<Integer> sampleInput = new ArrayList<>(Arrays.asList(1,1,1,3,3,3,4,4,4));
    String actualValue = numberRangeSummarizer.summarizeCollection(sampleInput);
    String expectedValue = "1, 1, 1, 3, 3, 3-4, 4, 4";

    assertEquals(expectedValue,actualValue);

  }

}