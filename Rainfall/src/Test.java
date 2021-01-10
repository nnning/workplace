import java.io.*;

public class Test {

  public static void main(String[] args) {
	 try{ 
	 File f = new File("Test.txt");
	BufferedReader is = new BufferedReader(
	new FileReader(f));
	
	String inputLine;
	
	while((inputLine = is.readLine())!=null){
		System.out.println(inputLine);
		
	}
	is.close();
	 } catch(IOException e) {
		 System.out.println(e);
	 }
	 
  }
} 