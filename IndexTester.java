import java.util.*;
import java.io.*;
/**
 * IndexTester that for different types of Indexes writes them into an output file
 * @author Ali Sultan
 */
public class IndexTester
{
    /**
     * Method to test the three types of indexes
     * Creates a file called out and writes the index to it
     */
    public static void main(String[] args){
        long totaltime1 = 0; // store for total time to create the index
        long totaltime2 = 0; // store for total time to write the index in output file
        for (int j=0;j <5;j++){
        try{
            FileReader fr=new FileReader("English.txt");    
            BufferedReader br=new BufferedReader(fr); // reader that will read from the english.txt dictionary
            ArrayList<String> dict = new ArrayList<>(); // container to store all the english dictionary words
            Index idex = new TreeIndex(); // use the appropriate indexes
            String line = br.readLine();

            while (line!=null){
                dict.add(line); //add the words into the list
                line = br.readLine();
            }
            br.close();
            FileReader fr1=new FileReader("620k.txt");    
            BufferedReader br1=new BufferedReader(fr1); // this reader will read from the book speceified 
            int linecount  = 1; // variable to keep track of the nth line
            String line1 = br1.readLine();
            
            long StartTime = System.currentTimeMillis();
            while (line1!= null){
                String[] words = line1.split("[^A-Za-z]+");
                for (int i =0 ; i< words.length ; i++){
                    String word = words[i].toLowerCase();
                    if (idex.searchDict(dict,word)==true){

                        idex.addIndex(word,linecount);

                    }

                }
                line1 = br1.readLine();
                linecount++;}
            

            br1.close(); //close the bufferwriter
            long EndTime = System.currentTimeMillis();
            totaltime1=totaltime1 + (EndTime - StartTime);
            
            

            PrintWriter out = new PrintWriter (new File("myout.txt")); // printwriter to write to the output file
            long StartTime1 = System.currentTimeMillis();
            int total = idex.SizeSort(); //sort(if needed) and return the size
            for (int k=0; k<total ; k++){
                out.println(idex.toString(k));
            }
            out.close();
            long EndTime1 = System.currentTimeMillis();
            totaltime2=totaltime2 + (EndTime1 - StartTime1);
  
        }catch(Exception e){
            System.out.println(e); //print the exception caught on the console

        }
    }
    System.out.println("Time to create the word Index: "+(totaltime1/5));
    System.out.println("Time to write Index into the output file: "+(totaltime2/5));
           
    }
}

