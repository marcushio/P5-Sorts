
/**
 * Write a description of class P5Program here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
import java.io.*; 

public class P5Program
{
    Scanner keyboard;
    BufferedReader fileReader; 
    Timer timer; 
    
    ArrayList<String> words; 
    ArrayList<Integer> numbers; 
    String filename; 
    String LS = System.lineSeparator(); 
    
    /**
     * 
     */
    public P5Program(){
        keyboard = new Scanner(System.in); 
        timer = new Timer(); 
    }
    
    
    /**
     * Makes all the calls involved in how this program sorts (i.e. timing etc.)
     */
    private String sort(){
        
        return "sorted"; 
    }
    
    
    /**
     * Get's input from what the user typed
     * @return userInput - the string the user typed. 
     */
    private String takeInput(){
        String userInput = null; 
        try{
            userInput = keyboard.nextLine(); 
        } catch(Exception ex){
            System.out.println("Input error"); 
        }
        return userInput; 
    }
    
    
    /**
     * Checks to see what type of data the file contains
     */
    private int typeCheck(){
        //if expression probably helpful here
        char sample = getNextLine().charAt(0);
        if(Character.isLetter(sample))return 1;
        else if(Character.isDigit(sample))return 0;
        return -1; 
    }
    
    
    /**
     * Reads the line of the document. Mainly made so I don't have to make so many trycatch
     */
    private String getNextLine(){
        String textLine = null; 
        try{
            textLine = fileReader.readLine();
        }catch(Exception ex) {System.out.println("Read error"); }  
        return textLine; 
    }
    
    
    /**
     * 
     */
    private void run(){
        System.out.println("Enter filename for the data you want to sort"); 
        try{
            filename = takeInput(); 
            fileReader = new BufferedReader(new FileReader(filename));
            String dataLine = null; 
             
            
            if(typeCheck() == 0){
                while((dataLine = getNextLine()) != null){
                    numbers = new ArrayList<Integer>();
                    numbers.add(Integer.parseInt(dataLine)); 
                }
            } else if(typeCheck() == 1){
                while((dataLine = getNextLine()) != null){
                    words = new ArrayList<String>(); 
                    words.add(dataLine); 
                }
            } else System.out.println("Data contains invalid characters (not letters or numbers)"); 
        }catch(IOException ex){
            System.out.println("IOError");
        } 
        catch(Exception ex){
            System.out.println("Error"); 
        }
        sort();     
    }
    
    
    /**
     * Makes the core method calls to run the program. 
     */
    public static void main(String[] args){
        P5Program p5 = new P5Program(); 
        p5.run();
    }
}
