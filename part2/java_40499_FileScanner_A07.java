import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40499_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        countTxtFiles(new File(directoryPath));
    }

    private static void countTxtFiles(File directory) {
        int txtFileCount = 0;
        int totalLines = 0;

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        totalLines++;
                        scanner.nextLine();
                    }
                    txtFileCount++;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                countTxtFiles(file);
            }
        }

        System.out.println("Total number of .txt files: " + txtFileCount);
        System.out.println("Total number of lines in .txt files: " + totalLines);
    }
}