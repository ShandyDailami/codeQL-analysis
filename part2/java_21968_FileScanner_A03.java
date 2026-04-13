import java.io.File;
import java.util.Scanner;

public class java_21968_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles((dir2, name) -> name.endsWith(".txt"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("File Name: " + file.getName());
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Line: " + line);
                    // here you can add your injection attempt or other security-sensitive operations
                }
                scanner.close();
            }
        } else {
            System.out.println("No txt files found in directory.");
        }
    }
}