import java.io.File;
import java.util.Scanner;

public class java_27254_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();

            File file = new File(directory, fileName);

            if (file.exists() && file.canRead()) {
                System.out.println("Reading file content:");
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
               
                    // This is a very basic form of injection. A real-world application would need to use
                    // a more secure method to prevent SQL injection or XSS attacks.
                    String injection = "<script>alert('Attempting injection')</script>";
                    System.out.println("Injected line: " + injection);
                }

                fileScanner.close();
            } else {
                System.out.println("File not found or cannot be read.");
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}