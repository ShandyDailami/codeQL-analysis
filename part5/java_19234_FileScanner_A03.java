import java.io.File;
import java.util.Scanner;

public class java_19234_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the word to search for:");
        String searchWord = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Scanner fileScanner = null;
                    try {
                        fileScanner = new Scanner(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains(searchWord)) {
                            System.out.println("Found line in file: " + file.getName() + ": " + line);
                        }
                    }
                    fileScanner.close();
                }
            }
        }
    }
}