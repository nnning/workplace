package app;

/**
 * GoldenRatio
 */
public class GoldenRatio {

  public static void main(String[] args) {

    double result;
    
    for (double i = 1; i <= 20; i++) {

      for (double j = 20; j >= 1; j--) {
        
        if(i*1.75 < j || i >= j*0.75) {
          continue;
        }
        
        result = (double)i/j;
        System.out.println(i + " divide by " + j + ": " + result);
        
      }
    }
  }
}