import java.io.File;
import java.util.Scanner;

public class java_24164_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}