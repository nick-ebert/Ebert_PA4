import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile){
        try{
            FileReader inFile = new FileReader(dataFile);
            Scanner scnr = new Scanner(inFile);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine().trim();
                String[] data = line.split(" ");
                for(String s: data){
                    if(!wordCounter.containsKey(s)){
                        wordCounter.put(s, 1);
                    } else{
                        int count = wordCounter.get(s);
                        wordCounter.put(s, count+1);
                    }
                }
            }
            closeFileReader(inFile);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void write(String outputFile) {
        try {
            PrintWriter outputStrings = new PrintWriter(outputFile);
            for(Map.Entry<String, Integer> i: wordCounter.entrySet()){
                outputStrings.println(i.getKey() + ": " + i.getValue());
            }
            outputStrings.close();
        } catch (IOException ex) {
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
}
