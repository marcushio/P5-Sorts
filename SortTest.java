import java.util.*; 
import java.io.*; 
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 * CS2050-003
 * 
 */
public class SortTest
{
    ArrayList<Integer> numbers; 
    ArrayList<Integer> sorted; 
    BufferedReader reader; 
    Sorter sorter;
    
    public SortTest(){
        numbers = new ArrayList<Integer>(); 
        sorted = new ArrayList<Integer>(); 
        sorter = new Sorter(); 
    }
    
    public void test(){
        try(BufferedReader reader = new BufferedReader(new FileReader("mynumbers.txt"))){
            String dataLine = null; 
            while((dataLine = reader.readLine()) != null){  
                numbers.add(Integer.parseInt(dataLine)); 
                System.out.println(numbers.get((numbers.size()-1))); 
            }
            
            sorted = sorter.numBubbleSort(numbers);
            System.out.println("bubble--------------"); 
            for(Integer element : sorted){
                System.out.println(element); 
            }
            sorted = null;
            sorted = sorter.numSelectionSort(numbers); 
            System.out.println("selection---------------");
            for(Integer element : sorted){
                System.out.println(element); 
            }
            sorted = null;
            sorted = sorter.numJavaSort(numbers);
            System.out.println("java=============");
            for(Integer element : sorted){
                System.out.println(element); 
            }
        }catch(Exception ex){
            System.out.print("IOException"); 
        }
    }
}
