import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04159_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();
        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.getName().equals(fileName)) {
                try {
                    if (file.isFile()) {
                        if (file.canRead()) {
                            System.out.println("File Content:");
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                            fileScanner.close();
                        } else {
                            System.out.println("Cannot read file " + file.getName());
                        }
                    } else {
                        System.out.println("Not a file: " + file.getName());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
        scanner.close();
    }
}