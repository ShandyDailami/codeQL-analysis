import java.io.File;
import java.util.Scanner;

public class java_03532_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                    }
                } else {
                    System.out.println("Cannot read file. Check permissions.");
                }
            } else {
                System.out.println("Given path is not a file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}