import java.util.*;
/**
 * Index interface which is implemented by the three subclasses for indexes
 * @author Ali Sultan 
 */
public interface Index
{
    
    /**
     * method to search a word in the dictionary before making an index out of it
     * @boolean true if found
     */
    public boolean searchDict(ArrayList<String> dict, String wordSearched);
    
    /**
     * method to add a new entry into the index
     * if the entry is already there, the line number is added to its respective treeset
     */
    public void addIndex(String NewWord, int linenum);
    
    /**
     * @return the index information as a string for certain nth index
     */
    public String toString(int n);
    
    /**
     * @return the number of indexes already added
     */
    public int SizeSort();
    
    
    
    
    
}
