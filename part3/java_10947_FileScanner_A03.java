import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10947_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Invalid directory path!");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively list files in subdirectories
                    listFiles(file, indent + "  ");
                } else {
                    // Print file name
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}