import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08236_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file";  // Replace with your file path
        String keyword = "AuthFailure";  // Replace with your keyword

        File file = new File(filePath);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        int lineCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(keyword)) {
                lineCount++;
            }
        }

        System.out.println("The keyword '" + keyword + "' was found in " + lineCount + " lines.");
        scanner.close();
    }
}