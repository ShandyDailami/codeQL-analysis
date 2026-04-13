import java.io.File;
import java.util.Scanner;

public class java_31454_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            System.out.println("Please enter the file extension (e.g., .txt or .java):");
            String extension = scanner.nextLine();

            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    } else {
                        System.out.println("Directory: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files found with the specified extension.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }
}