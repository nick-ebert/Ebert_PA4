public class Application {
    public static void main(String [] args){
        DuplicateCounter dCounter = new DuplicateCounter();
        dCounter.count("C:\\Users\\nsebe\\IntelliJ-workspace-OOP\\Ebert_PA4\\Ebert_p2\\src\\problem2.txt");
        dCounter.write("unique_word_counts.txt");
    }
}
