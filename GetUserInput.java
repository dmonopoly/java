import java.io.*;

public class GetUserInput {
    public static void main (String[] args) {
       System.out.print("Enter your name and press Enter: ");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String name = null;
       try {
           name = br.readLine();
       } catch (IOException e) {
           System.out.println("Error!");
           System.exit(1);
       }
       System.out.println("Your name is " + name);
   }
}