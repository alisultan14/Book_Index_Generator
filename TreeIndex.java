import java.util.*;
/**
 * Class to create the index of a book using a TreeMap of string keys (words), and values as the tree set of line numbers
 * @author Ali Sultan
 */
public class TreeIndex implements Index
{
     TreeMap<String, TreeSet<Integer>> TM ; // treehmap stores the words and the treeset of line numbers
     ArrayList<String> wordlist;  // store the list of words in the indexes for printing and sortin purposes 
    //ArrayList<TreeSet<Integer>> linelist = new ArrayList<>(); // store the list of line sets in the indexes for printing and sorting purposes
    /**
     * Constructor
     */
    public TreeIndex(){
        TM = new TreeMap<String, TreeSet<Integer> >();
    }
    
    /**
     * search the dictionary of words
     * @return true if the word has been found
     * return false otherwise
     */
    public boolean searchDict(ArrayList<String> dict, String wordSearched){
        if (Collections.binarySearch(dict, wordSearched) >= 0){ // if the word has been found successfully
            return true;}
        return false; //else return false
    }
    
    /**
     * @param the word to be added and the line number on which it is found
     */
    public void addIndex(String NewWord, int linenum){
        if (TM.containsKey(NewWord)){
          TM.get(NewWord).add(linenum);
          
        } else{
         TreeSet<Integer> temp = new TreeSet<>();
         temp.add(linenum);
         TM.put(NewWord,temp);
         
        
        }

        
    }
    /**
     * @return the size of the index currently
     * no sorting needed
     */
    public int SizeSort(){
        wordlist = new ArrayList<>(TM.keySet());
        return TM.size();
    }
    /**
     * @ return the index information, the word and the set on lines associated with it
     */
    public String toString(int n){
        return wordlist.get(n)+" "+TM.get(wordlist.get(n)).toString();
    }


}
