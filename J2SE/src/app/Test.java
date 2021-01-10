package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

  public static void main(String[] args) {

    File file = new File("test.txt");
    
    try (FileInputStream inputStream = new FileInputStream(file)) {
      byte[] all = new byte[(int)file.length()];
      inputStream.read(all);
      for (byte b : all) {
        System.out.print(b + " ");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
}