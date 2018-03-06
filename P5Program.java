
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
    Sorter sorter; 
    
    ArrayList<Integer> numbers; 
    ArrayList<Integer> bubbleSortedNums = new ArrayList<>();
    ArrayList<Integer> insertionSortedNums = new ArrayList<>();  
    ArrayList<Integer> javaSortedNums = new ArrayList<>(); 
    ArrayList<String> words; 
    ArrayList<String> bubbleSortedWords = new ArrayList<String>();
    ArrayList<String> insertionSortedWords = new ArrayList<String>();  
    ArrayList<String> javaSortedWords = new ArrayList<String>(); 
    
    String filename; 
    String LS = System.lineSeparator(); 
    
    /**
     * 
     */
    public P5Program(){
        keyboard = new Scanner(System.in); 
        timer = new Timer(); 
        sorter = new Sorter(); 
    }
    
    
    /**
     * Makes all the calls involved in how this program sorts (i.e. timing etc.)
     */
    private String sortNumbers(){
        String sortResults = null; 
        bubbleSortedNums = new ArrayList<Integer>();
        insertionSortedNums = new ArrayList<Integer>();  
        javaSortedNums = new ArrayList<Integer>(); 
        
        timer.start();
        bubbleSortedNums =  sorter.numBubbleSort(numbers);
        timer.stop(); 
        sortResults = timer.reportTimes(); 
        
        timer.start(); 
        insertionSortedNums = sorter.numSelectionSort(numbers); 
        timer.stop(); 
        sortResults += timer.reportTimes(); 
        
        timer.start();
        javaSortedNums = sorter.numJavaSort(numbers); 
        timer.stop(); 
        sortResults += timer.reportTimes(); 
        
        System.out.println(sortResults); 
        return sortResults; 
    }
    
    
    /**
     * 
     */
    private String sortWords(){
        String sortResults = null; 
        bubbleSortedWords = new ArrayList<String>();
        insertionSortedWords = new ArrayList<String>();  
        javaSortedWords = new ArrayList<String>(); 
        
        timer.start();
        bubbleSortedWords=  sorter.wordBubbleSort(words);
        timer.stop(); 
        sortResults = timer.reportTimes(); 
        
        timer.start(); 
        insertionSortedWords = sorter.wordSelectionSort(words); 
        timer.stop(); 
        sortResults += timer.reportTimes(); 
        
        timer.start();
        javaSortedWords = sorter.wordJavaSort(words); 
        timer.stop(); 
        sortResults += timer.reportTimes(); 
        
        System.out.println(sortResults); 
        return sortResults;    
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
        int type = -1; 
        try(BufferedReader sampler = new BufferedReader(new FileReader(filename))){
            char sample = sampler.readLine().charAt(0);
            if(Character.isLetter(sample)){
                type = 1;
                words = new ArrayList<String>(); 
            }
            else if(Character.isDigit(sample)){
                type = 0;
                numbers = new ArrayList<Integer>();
            }
            else type = -1; 
        }catch(IOException ex){
            System.out.println("IOException: try again"); 
        }
        return type; 
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
        try{
            String dataLine = null; 
            System.out.println("Enter filename for the number data you want to sort"); 
            filename = takeInput(); 
            fileReader = new BufferedReader(new FileReader(filename));
            
            if(typeCheck() == 0){
                while((dataLine = getNextLine()) != null){  
                    numbers.add(Integer.parseInt(dataLine)); 
                }
                sortNumbers(); 
            } else System.out.println("Data contains invalid characters"); 
            
            System.out.println("Enter filename for the word data you want to sort"); 
            filename = takeInput(); 
            fileReader = new BufferedReader(new FileReader(filename));
            if(typeCheck() == 1){
                while((dataLine = getNextLine()) != null){                 
                    words.add(dataLine); 
                }
                sortWords();
            } else System.out.println("Data contains invalid characters"); 
        }catch(IOException ex){
            System.out.println("IOError");
        } 
        catch(Exception ex){
            System.out.println("Error"); 
        }
            
    }
    
    
    /**
     * Makes the core method calls to run the program. 
     */
    public static void main(String[] args){
        P5Program p5 = new P5Program(); 
        p5.run();
    }
}
