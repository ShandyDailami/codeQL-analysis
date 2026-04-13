import java.io.File;
import java.util.Scanner;

public class java_01137_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
            if (files != null) {
                for (File file : files) {
                    if (file.canRead()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getPath());
                    } else {
                        System.out.println("Unable to read file: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files with extension " + fileExtension + " found in the directory " + directoryPath);
            }
        } else {
            System.out.println("The directory " + directoryPath + " does not exist or is not a directory.");
        }

        scanner.close();
    }
}