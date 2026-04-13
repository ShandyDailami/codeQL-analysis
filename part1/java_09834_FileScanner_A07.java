import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09834_FileScanner_A07 {
    public static void main(String[] args) {
        String targetWord = "A07_AuthFailure";
        String filePath = "src/main/resources/textfile.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            int count = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                count += line.split(targetWord, -1).length - 1;
            }
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please provide a valid file path.");
        }
    }
}