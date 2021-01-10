package app;


public class Millionaire {

  public static void main(String[] args) {

    double profit = 0;
    int principal = 12000;
    
    for (int i = 1; i < 100; i++) {
      
    	if(profit >= 1000000) {
       // System.out.println("year: " + i);
        break;
      }
      
      profit = (principal*i) * (Math.pow((1+0.2), i));
      System.out.println("Year: " + i + ", the profit is: " + profit);
    }
  }
}