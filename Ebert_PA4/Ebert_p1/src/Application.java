import java.io.IOException;

public class Application {
    public static void main(String [] args) throws IOException {
        DuplicateRemover dRemover = new DuplicateRemover();
        dRemover.remove("C:\\Users\\nsebe\\IntelliJ-workspace-OOP\\Ebert_PA4\\src\\problem1.txt");
        dRemover.write("unique_words.txt");
    }
}
