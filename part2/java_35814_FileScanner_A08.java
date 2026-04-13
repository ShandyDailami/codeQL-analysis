import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35814_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] listOfFiles = dir.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The specified file does not exist or is not a directory.");
        }
    }
}