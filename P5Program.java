
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
    ArrayList<String> selectionSortedWords = new ArrayList<String>();  
    ArrayList<String> javaSortedWords = new ArrayList<String>(); 
    
    String filename; 
    static final String OUTPUT_FILENAME = "P5Output.txt"; 
    String results; 
    String LS = System.lineSeparator(); 
    
    /**
     * 
     */
    public P5Program(){
        keyboard = new Scanner(System.in); 
        timer = new Timer(); 
        sorter = new Sorter(); 
        results = ""; 
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
        selectionSortedWords = new ArrayList<String>();  
        javaSortedWords = new ArrayList<String>(); 
        
        timer.start();
        bubbleSortedWords=  sorter.wordBubbleSort(words);
        timer.stop(); 
        sortResults = timer.reportTimes(); 
        
        timer.start(); 
        selectionSortedWords = sorter.wordSelectionSort(words); 
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
     * Writes the results to a txt file.
     */
    private void writeResults(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUTPUT_FILENAME), true))){
            writer.write(results);
        }catch(Exception ex) {System.out.println("Couldn't write to file"); }
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
     * 
     */
    private void run(){
        try{
            String dataLine = null; 
            System.out.println("Enter filename for the data you want to sort"); 
            filename = takeInput(); 
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            
            if(typeCheck() == 0){
                while((dataLine = fileReader.readLine()) != null){  
                    numbers.add(Integer.parseInt(dataLine)); 
                }
                results += "There are " + numbers.size() + " numbers in this file." + LS + sortNumbers() + LS; 
            } else if(typeCheck() == 1){
                while((dataLine = fileReader.readLine()) != null){                 
                    words.add(dataLine); 
                }
                results += "There are " + words.size() + " words in this file." + LS + sortWords() + LS; 
            } else System.out.println("Data contains invalid characters"); 
            fileReader.close(); 
        } catch(Exception ex){
            System.out.println("There is something wrong with that file."); 
        }
        System.out.println("Writing to P5Output.txt"); 
        writeResults();     
    }
    
    
    /**
     * Makes the core method calls to run the program. 
     */
    public static void main(String[] args){
        P5Program p5 = new P5Program(); 
        boolean running = true; 
        while(running){
            p5.run();
            System.out.println("Enter 'y' to load another file, any other character will exit the program"); 
            if(!p5.takeInput().equalsIgnoreCase("y")){
                running = false; 
            }
        }
    }
}
