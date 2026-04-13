import java.io.File;
import java.util.Scanner;

public class java_06811_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt"); // Replace with your file path
        Scanner scanner = new Scanner(file);

        String wordToSearch = "AuthFailure";
        boolean found = false;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(wordToSearch)) {
                found = true;
                System.out.println("Word found in line: " + line);
            }
        }

        if (!found) {
            System.out.println("Word not found in file.");
        }

        scanner.close();
    }
}