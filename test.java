import java.io.*;
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 * CS2050-003
 * 
 */

public class test
{
   
    public void testLine(){
        try(BufferedReader r = new BufferedReader(new FileReader("words.txt"))){
            System.out.println(r.readLine());
        } catch(Exception ex){
            System.out.println("Error");
        } 
    }
    public void testTypeCheck(){
        try(BufferedReader r = new BufferedReader(new FileReader("words.txt"))){
            char sample = r.readLine().charAt(0);
            System.out.println("is word in words?"+ sample + Character.isLetter(sample));
            BufferedReader nr = new BufferedReader(new FileReader("numbers.txt"));
            char numSample = nr.readLine().charAt(0);
            System.out.println("is num in numbers?"+ numSample + Character.isDigit(numSample));
        } catch(Exception ex){
            System.out.println("Error");
        } 
    }
}
