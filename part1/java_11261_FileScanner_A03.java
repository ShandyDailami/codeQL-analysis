import java.io.File;
import java.util.Scanner;

public class java_11261_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file extension (without dot):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found with extension: " + fileExtension);
        } else {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File absolute path: " + file.getAbsolutePath());
                    System.out.println("---------------------------");
                }
            }
        }

        scanner.close();
    }
}