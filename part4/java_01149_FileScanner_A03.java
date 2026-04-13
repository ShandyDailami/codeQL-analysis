import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01149_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String path = scanner.nextLine();
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();
            File file = new File(path + File.separator + fileName);

            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canRead()) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    } else {
                        System.out.println("You do not have permission to read this file.");
                    }
                } else {
                    System.out.println("The specified file does not exist.");
                }
            } else {
                System.out.println("The specified file does not exist.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter a valid directory path and file name.");
        }
    }
}