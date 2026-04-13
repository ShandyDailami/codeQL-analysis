import java.io.File;
import java.util.Scanner;

public class java_31574_FileScanner_A03 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(directory, fileName);

        if (file.exists() && file.isFile() && fileName.endsWith(".txt")) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } else {
            System.out.println("File not found or not a text file.");
        }
    }
}