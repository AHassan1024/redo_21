import org.junit.Test;

import static org.junit.Assert.*;

public class StateMachineTest {

  @Test
  public void binMachine() {
    assertFalse(StateMachine.binMachine("-010101")); // added test case
    assertFalse(StateMachine.binMachine("No, I'm a number, please!!")); // added test case
    assertFalse(StateMachine.binMachine("123"));
    assertFalse(StateMachine.binMachine("1010a"));
    assertFalse(StateMachine.binMachine("a1010"));
    assertFalse(StateMachine.binMachine("01a"));
    assertTrue(StateMachine.binMachine("000")); // added test case
    assertTrue(StateMachine.binMachine("11101")); // added test case
    assertTrue(StateMachine.binMachine("111"));
    assertTrue(StateMachine.binMachine("101010"));
    assertTrue(StateMachine.binMachine("1"));
    assertTrue(StateMachine.binMachine("010101"));
    assertTrue(StateMachine.binMachine("010"));
  }

  @Test
  public void binConvMachine() {
    assertEquals(-1, StateMachine.binConvMachine("123"));
    assertEquals(-1, StateMachine.binConvMachine("01a"));
    assertEquals(7, StateMachine.binConvMachine("111"));
    assertEquals(42, StateMachine.binConvMachine("101010"));
    assertEquals(21, StateMachine.binConvMachine("010101"));
    assertEquals(1, StateMachine.binConvMachine("1"));
    assertEquals(2, StateMachine.binConvMachine("010"));
    assertEquals(-1,
        StateMachine.binConvMachine("1213443554241435657665443214567787564534231432564756875645"));
  }

  @Test
  public void numMachine() {
    assertFalse(StateMachine.numMachine("abc"));
    assertFalse(StateMachine.numMachine("12x"));
    assertFalse(StateMachine.numMachine("3.14"));
    assertTrue(StateMachine.numMachine("123"));
    assertTrue(StateMachine.numMachine("2112"));
    assertTrue(StateMachine.numMachine("1928"));
    assertTrue(StateMachine.numMachine("93"));
    assertTrue(
        StateMachine.numMachine("12134043554241435657665443214567787564534231432564756875645"));
  }

  @Test
  public void decMachine() {
    assertFalse(StateMachine.decMachine("abc.d")); // added test case
    assertFalse(StateMachine.decMachine("12..31"));
    assertFalse(
        StateMachine.decMachine("+1213443554241435657665443214567787564534231432564756875645"));
    assertFalse(StateMachine.decMachine("12x"));
    assertFalse(StateMachine.decMachine("a.2"));
    assertTrue(StateMachine.decMachine("12.")); // added test case
    assertTrue(StateMachine.decMachine("1.23"));
    assertTrue(StateMachine.decMachine("123"));
    assertTrue(StateMachine.decMachine("25.101993"));
    assertTrue(StateMachine.decMachine("2112"));
    assertTrue(StateMachine.decMachine("21.12"));
    assertTrue(StateMachine.decMachine("3.14"));
  }

  @Test
  public void signMachine() {
    assertFalse(StateMachine.signMachine("12-31"));
    assertFalse(StateMachine.signMachine("3.14"));
    assertFalse(StateMachine.signMachine("-3.14"));
    assertFalse(StateMachine.signMachine("-1ab"));
    assertFalse(StateMachine.signMachine("+1ab"));
    assertFalse(StateMachine.signMachine("+ab1"));
    assertFalse(StateMachine.signMachine("-ab1"));
    assertTrue(StateMachine.signMachine("-123"));
    assertTrue(StateMachine.signMachine("+123"));
    assertTrue(StateMachine.signMachine("+100"));
    assertTrue(StateMachine.signMachine("-9"));
    assertTrue(StateMachine.signMachine("30"));
    assertTrue(
        StateMachine.signMachine("+1213443554241435657665443214567787564534231432564756875645"));
  }

  @Test
  public void numberMachine() {
    assertFalse(StateMachine.numberMachine("12..31"));
    assertFalse(StateMachine.numberMachine("12x"));
    assertFalse(StateMachine.numberMachine("12-31"));
    assertFalse(StateMachine.numberMachine("abcde"));
    assertFalse(StateMachine.numberMachine("-ab1"));
    assertFalse(StateMachine.numberMachine("-1.2a"));
    assertTrue(StateMachine.numberMachine("+1.23"));
    assertTrue(StateMachine.numberMachine("-123"));
    assertTrue(
        StateMachine.numberMachine("+1213443554241435657665443214567787564534231432564756875645"));
    assertTrue(
        StateMachine.numberMachine("+1213443554241435657665443214.567787564534231432564756875645"));
    assertTrue(StateMachine.numberMachine("2112"));
    assertTrue(StateMachine.numberMachine("-21.12"));
    assertTrue(StateMachine.numberMachine("+3.14"));
  }

  @Test
  public void wordMachine() {
    assertFalse(StateMachine.wordMachine("s-thing"));
    assertFalse(StateMachine.wordMachine("self-taught"));
    assertFalse(StateMachine.wordMachine("C++"));
    assertFalse(StateMachine.wordMachine("Overture1928"));
    assertTrue(StateMachine.wordMachine("something"));
    assertTrue(StateMachine.wordMachine("SoMeThInG"));
    assertTrue(StateMachine.wordMachine("Something"));
    assertTrue(StateMachine.wordMachine("hello"));
    assertTrue(StateMachine.wordMachine("Bye"));
    assertTrue(StateMachine.wordMachine("Java"));
    assertTrue(StateMachine.wordMachine("HTML"));
  }

  @Test
  public void wordyMachine() {
    assertFalse(StateMachine.wordyMachine("SoMeThInG"));
    assertFalse(StateMachine.wordyMachine("Overture1928"));
    assertFalse(StateMachine.wordyMachine("JAVA"));
    assertFalse(StateMachine.wordyMachine("JaVa"));
    assertTrue(StateMachine.wordyMachine("self-taught"));
    assertTrue(StateMachine.wordyMachine("s-thing"));
    assertTrue(StateMachine.wordyMachine("Java"));
    assertTrue(StateMachine.wordyMachine("java"));
    assertTrue(StateMachine.wordyMachine("something"));
    assertTrue(StateMachine.wordyMachine("Something"));
  }

  @Test
  public void sentenceMachine() {
    // assertFalse(StateMachine.sentenceMachine("s-thing is a sentence"));
    // assertFalse(StateMachine.sentenceMachine("word"));
    assertFalse(StateMachine.sentenceMachine("Hi"));
    assertFalse(StateMachine.sentenceMachine("3.14"));
    assertFalse(StateMachine.sentenceMachine("word  "));
    assertFalse(StateMachine.sentenceMachine("overture 1928"));
    assertFalse(StateMachine.sentenceMachine("He has. Sorry? Did not mean to!"));
    assertTrue(StateMachine.sentenceMachine("word test"));
    assertTrue(StateMachine.sentenceMachine("something is a sentence"));
    assertTrue(StateMachine.sentenceMachine("SoMeThInG is a sentence"));
    assertTrue(StateMachine.sentenceMachine("Something  is a Sentence"));
    assertTrue(StateMachine.sentenceMachine("I am a student"));
    assertTrue(StateMachine.sentenceMachine("I program in Java"));
  }

  @Test
  public void grammarMachine() {
    assertFalse(StateMachine.grammarMachine("Something"));
    assertFalse(StateMachine.grammarMachine("something is a sentence"));
    assertFalse(StateMachine.grammarMachine("s-thing is a sentence"));
    assertFalse(StateMachine.grammarMachine("Hi! i am a Java student"));
    assertTrue(StateMachine.grammarMachine("SoMeThInG is a sentence"));
    assertTrue(StateMachine.grammarMachine("Something  is a Sentence"));
    assertTrue(StateMachine.grammarMachine("He has. Sorry? Did not mean to!"));
    assertTrue(StateMachine.grammarMachine("Hi! I am a Java student"));
    assertTrue(StateMachine.grammarMachine("Roses are red, violets are blue"));
  }

  @Test
  public void calcMachine() {
    assertEquals(2.0, StateMachine.calcMachine("1+1="), 0.01);
    assertEquals(222.0, StateMachine.calcMachine("111+111="), 0.01);
    assertEquals(0.0, StateMachine.calcMachine("1-1="), 0.01);
    assertEquals(0.0, StateMachine.calcMachine("111-111="), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("=+-23432"), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("-2+-1="), 0.01);
    assertEquals(114.0, StateMachine.calcMachine("3+7+5+0+99="), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("12+a"), 0.01);
    assertEquals(1.221, StateMachine.calcMachine("0.111+1.11="), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("-2.2+-1"), 0.01);
    assertEquals(10056.5, StateMachine.calcMachine("3*7.0+5+0+99/2-5+9999="), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("12.+a"), 0.01);
    assertEquals(10056.5, StateMachine.calcMachine("3 * 7.0 + 5 + 0 + 99 / 2 - 5 + 9999 ="), 0.01);
    assertEquals(10056.5, StateMachine.calcMachine("3 * 7.0 + 5 + 0 +99/2-5 + 9999 ="), 0.01);
    assertEquals(Double.NaN, StateMachine.calcMachine("3*7.0+5+0+99/2-5+9999"), 0.01);
  }
}
