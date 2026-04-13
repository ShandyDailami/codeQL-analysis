import java.io.File;
import java.util.Scanner;

public class java_29848_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists at the given path.");
            System.out.println("Reading contents of the file...");

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
           
            }
            fileScanner.close();

        } else {
            System.out.println("File does not exist at the given path.");
        }

        scanner.close();
    }
}