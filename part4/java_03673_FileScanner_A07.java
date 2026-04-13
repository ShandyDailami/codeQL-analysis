import java.io.File;
import java.util.Scanner;

public class java_03673_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}