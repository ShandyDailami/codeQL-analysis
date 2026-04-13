import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_23569_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the word to search: ");
        String wordToSearch = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(directoryPath, wordToSearch);
        fileScanner.scan();
    }

}

class FileScanner {
    private String directoryPath;
    private String wordToSearch;

    public java_23569_FileScanner_A07(String directoryPath, String wordToSearch) {
        this.directoryPath = directoryPath;
        this.wordToSearch = wordToSearch;
    }

    public void scan() {
        try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    System.out.println("Found the word in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}