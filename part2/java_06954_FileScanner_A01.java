import java.io.File;
import java.util.Scanner;

public class java_06954_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File file = new File(filePath + "." + fileExtension);

        if (file.exists()) {
            if (file.canRead()) {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                }
            } else {
                System.out.println("The file cannot be read by the current user.");
            }
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }
}