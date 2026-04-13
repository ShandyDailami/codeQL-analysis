import java.io.File;
import java.util.Scanner;

public class java_26678_FileScanner_A03 {
    public static void main(String[] args) {
        System.out.println("Enter directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter file extension (without dot):");
            String extension = scanner.next();

            File[] files = directory.listFiles((dir, name) -> name.endsWith("." + extension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Reading contents of: " + file.getName());
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("No files with that extension found in the directory.");
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }
    }
}