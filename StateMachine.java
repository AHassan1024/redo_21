import javax.naming.InitialContext;


public class StateMachine {

// assertion makes sure the string is not a negative number
  public static boolean binMachine(String input) {
    int i = 0;
    boolean state = false;
    assert input.charAt(i) != '-';
    while (i < input.length()){
      char c = input.charAt(i);
      if (c != '0' && c != '1') {
        return state;
      }
      i++;
    }
    state = true;
    return state;
  }

  public static int binConvMachine(String input) {
    int i = 0;
    int denary = 0;
    if (binMachine(input)) {
      int length = input.length();
      while (i < length) {
        if (input.charAt(i) == '1'){
          denary += Math.pow(2, (length - 1 - i));
          }
        i++;
      }
      return denary;
    }
    else {
      denary = -1;
      return denary;
    }
  }

  public static boolean numMachine(String input) {
    for (int i = 0; i < input.length(); i++) {
      char digit = input.charAt(i);
      boolean checker = Character.isDigit(digit);
      if (checker == false) {
            return false;
          }
    }
    return true;
  }

  public static boolean decMachine(String input) {
    int counter = 0;
    boolean state = true;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      switch(c) {
        case '.' : 
        counter++;
        break;
        case '0' : case '1' : case '2' :
        case '3' : case '4' : case '5' :
        case '6' : case '7' : case '8' :
        case '9' :
        break;
        default :
        state = false;
      }
      if (counter > 1){
        state = false;
      }
    }
    return state;
  }

  public enum NumberState {
    INITIAL,
    SIGN,
    NUMBER,
    FAIL;
  }

  public static boolean signMachine(String input) {
    NumberState currentState = NumberState.SIGN;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (currentState == NumberState.SIGN) {
        if (c == '+' || c == '-' || Character.isDigit(c)) {
          currentState = NumberState.NUMBER;
        } else {
          currentState = NumberState.FAIL;
        }

      } else if(currentState == NumberState.NUMBER) {
        if (Character.isDigit(c)) {
          currentState = NumberState.NUMBER;
        } else {
          currentState = NumberState.FAIL;
        }

      } else {
        currentState = NumberState.FAIL;
      }
    }
    return (currentState != NumberState.FAIL);
  }

  public enum NumStates {
    SIGN,
    NUMBER,
    FAIL;
  }

  public static boolean numberMachine(String input) {
    NumStates currentState = NumStates.SIGN;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (currentState == NumStates.SIGN) {
        if (c == '+' || c == '-' || Character.isDigit(c)) {
          currentState = NumStates.NUMBER;

        } else {
          currentState = NumStates.FAIL;
        }
        
      } else if (currentState == NumStates.NUMBER) {
        boolean isNumber = decMachine(input.substring(i));
        if (isNumber) {
          currentState = NumStates.NUMBER;
        
        } else {
          currentState = NumStates.FAIL;
        }

      } else {
        currentState = NumStates.FAIL;
      }
    }
    return (currentState != NumStates.FAIL);
  }

  public enum WordMachineState {
    INITIAL,
    NOUN,
    FAIL;
  }
  public static boolean wordMachine(String input) {
    WordMachineState currentState = WordMachineState.INITIAL;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      boolean isLetter = Character.isUpperCase(c) || Character.isLowerCase(c);
      if (currentState == WordMachineState.INITIAL) {
  
        if (isLetter) {
          currentState = WordMachineState.NOUN;
        } else {
          currentState = WordMachineState.FAIL;
        }

      } else if (currentState == WordMachineState.NOUN) {

        if (isLetter) {
          currentState = WordMachineState.NOUN;
        } else {
          currentState = WordMachineState.FAIL;
        }

      } else {
          currentState = WordMachineState.FAIL;
      }
    }
    return (currentState != WordMachineState.FAIL);
  }

  public enum WordyMachineState {
    FIRSTLETTER,
    LOWER,
    FAIL;
  }

  public static boolean wordyMachine(String input) {
    WordyMachineState currentState = WordyMachineState.FIRSTLETTER;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (currentState == WordyMachineState.FIRSTLETTER) {
        
        if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
          currentState = WordyMachineState.LOWER;
        } else {
          currentState = WordyMachineState.FAIL;
        }
        // Character.isLetter(c)
      } else if (currentState == WordyMachineState.LOWER) {

        if (Character.isLetter(c) || c == '-') {
          
          if (Character.isUpperCase(c)) {
            currentState = WordyMachineState.FAIL;
          } else {
            currentState = WordyMachineState.LOWER;
          }

        } else {
          currentState = WordyMachineState.FAIL;
        }

      } else {
        currentState = WordyMachineState.FAIL;
      }
    }
    return (currentState != WordyMachineState.FAIL);
  }

  public static boolean sentenceMachine(String input) {
    int spaceCounter = 0;
    boolean state = true;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (Character.isUpperCase(c) || Character.isLowerCase(c) || c == ' ') {
        if (c == ' ') {
          spaceCounter++;
          int start = (input.lastIndexOf(' ', (i)));
          int end = (input.indexOf(' '));
          if (start > end) {
            state = true;
          } else if (start == end) {
            state = false;
          } else {
            state = wordMachine(input.substring(start, end));
          }
        }

      } else {
        state = false;
      }

    }
    
    if (spaceCounter == 0) {
      state = false;
    } 


    // 1. check that only alphabetical characters; (A-Z, a-z)
    // 2. check that at least one space
    // 3. check at least 2 words
    // TODO
    /* In this part you will recognise sentences as strings of words with spaces between words.
Examples: strings like "I am a student" or "I program in Java" must be accepted, while "Hi" or "3.14"
cannot. */
    return state;
  }

  public static boolean grammarMachine(String input) {
    // TODO
    return false;
  }

  public static double calcMachine(String input) {
    // TODO
    return Double.NaN;
  }
}
