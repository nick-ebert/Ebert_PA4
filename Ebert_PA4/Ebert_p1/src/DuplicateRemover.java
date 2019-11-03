import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile){
        uniqueWords = new HashSet<String>();
        try{
            FileReader inFile = new FileReader(dataFile);
            Scanner scnr = new Scanner(inFile);
            while(scnr.hasNext()){
                uniqueWords.add(scnr.next());
            }
            closeFileReader(inFile);
            scnr.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void closeFileReader(FileReader dataFile) {
        try {
            if (dataFile != null) { // Ensure "file" references a valid object
                dataFile.close(); // close() may throw IOException if fails
            }
        } catch (IOException closeExcpt) {
            System.out.println("Error closing file: " + closeExcpt.getMessage());
        }
    }

    public void write(String outputFile){
        try{
            String uniqueWord;
            PrintWriter outputStrings = new PrintWriter(outputFile);
            Iterator<String> setIterator;
            setIterator = uniqueWords.iterator();
            while(setIterator.hasNext()){
                uniqueWord = setIterator.next();
                outputStrings.println(uniqueWord);
            }
            outputStrings.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
