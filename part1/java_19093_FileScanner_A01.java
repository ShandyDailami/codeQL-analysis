import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_19093_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the word to search for:");
        String wordToSearch = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().contains(wordToSearch)) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("Found the word in file: " + file.getName() + " : " + line);
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}