import java.io.File;
import java.util.Scanner;

public class java_17552_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.canRead()) {
                System.out.println("Reading file content: ");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("Cannot read file content. Please ensure the file is not readable by the executing user.");
            }
        } else {
            System.out.println("File does not exist. Please enter a valid file path.");
        }
    }
}