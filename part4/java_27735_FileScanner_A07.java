import java.io.File;
import java.util.Scanner;

public class java_27735_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println("Line: " + line);
                }
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}