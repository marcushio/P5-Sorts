
/**
 * @author Marcus Trujillo
 * Assignment Number: 
 * Description of program if main/ class otherwise 
 * 
 * CS2050-003
 * 
 */
import java.util.*; 

public class Sorter
{
    /**
     *  Sorts the ArrayList using the bubble sort technique
     *  @param data the collection of data taken. 
     */
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> data){
        for (int i = data.size()-1; i>= 0; i--){
            for(int j = 0; j < i; j++){
                if(data.get(j) > data.get(j+1)){
                    int temp = data.get(j); 
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp); 
                }
            }
        }
        return data; 
    }
    
    
    /**
     * 
     */
    public ArrayList<Integer> selectionSort(ArrayList<Integer> data){
        for(int i=0; i<data.size()-1; i++){
            int minIndex = i;  
            for(int j=i+1; j<data.size(); j++){
                if(data.get(j) < data.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = data.get(i); 
            data.set(i, data.get(minIndex)); 
            data.set(minIndex, temp); 
        }
        return data; 
    }
    
    
    /**
     * 
     */
    public ArrayList<Integer> javaSort(ArrayList<Integer> data){
        Integer[] tempArray = new Integer[data.size()];
        tempArray = data.toArray(tempArray); 
        Arrays.sort(tempArray);
        return new ArrayList<Integer>(Arrays.asList(tempArray));  
    }
}
