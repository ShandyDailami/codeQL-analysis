import java.io.File;
import java.util.Scanner;

public class java_19418_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Please enter the word to search:");
        String searchWord = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null) {
            return;
        }

        for (File file : files) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(searchWord)) {
                    System.out.println("Line contains the word: " + line);
                }
            }
            fileScanner.close();
        }
    }
}