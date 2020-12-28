import java.util.*;
/**
 * Class to create the index of a book using an arrayList of Strings
 * @author Ali Sultan
 */
public class ListIndex implements Index
{
    ArrayList<Entry> list ; // arraylist of entries to store all the words with lines set
    ArrayList<String> wordlist ; // arraylist to sotre all the words for searching purposes

    /**7
     * Constructor
     */
    public ListIndex(){
        this.list = new ArrayList<>();
        wordlist = new ArrayList<>() ;
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

        int index = Collections.binarySearch(wordlist, NewWord);
        if (index >= 0){
            list.get(index).addLine(linenum); // if the word already exists in the index then just add the line number to its treeset
        
        } else{
            index = (index*-1)-1; // calculate the index for where the word must be stored
            wordlist.add(index,NewWord); // add word into the wordlist
            list.add(index,(new Entry(NewWord,linenum))); //add the entry into the entry list

        }

    }

    /**
     * @return the size of the index currently
     * no sorting required
     */
    public int SizeSort(){
        return list.size();
    }

    /**
     * @ return the index information, the word and the set on lines associated with it
     */
    public String toString(int n){
        return list.get(n).w + " " + list.get(n).set.toString();

    }

    /**
     * subclass to represent the entry objects
     * has the word
     * and a treeset to store all the line numbers
     */
    class Entry{
        String w; // variable to store the word
        TreeSet<Integer> set = new TreeSet<>(); // treeset for line numbers
        /**
         * constructor
         */
        Entry(String w, int linenum){
            this.w = w;
            set.add(linenum);
        }

        /**
         * method to add line into the tree set of an entry
         */
        void addLine(int k){
            set.add(k);
        }

    }
}
