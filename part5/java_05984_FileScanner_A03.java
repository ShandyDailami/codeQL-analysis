import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05984_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            if (file.exists()) {
                printFileContent(file);
            } else {
                System.out.println("File not found!");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static void printFileContent(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }
}