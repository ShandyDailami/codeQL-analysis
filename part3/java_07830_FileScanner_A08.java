import java.io.File;
import java.util.Scanner;

public class java_07830_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the extension (like .txt, .jpg, .png):");
        String extension = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        File[] filesWithExtension = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (filesWithExtension != null) {
            for (File file : filesWithExtension) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in " + directoryPath);
        }
    }
}