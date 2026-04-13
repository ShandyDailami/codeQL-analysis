import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38195_FileScanner_A01 {
    public static void main(String[] args) {
        // The first argument is the directory where the program will look for files.
        if (args.length == 0) {
            System.out.println("Usage: java BrokenAccessControl DIRECTORY");
            System.exit(1);
        }

        File dir = new File(args[0]);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error: " + args[0] + " is not a directory");
            System.exit(1);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Press ENTER to list files in " + dir.getAbsolutePath());
            scanner.nextLine();

            String[] list = dir.list();
            if (list == null) {
                System.out.println("Error: Unable to list files in " + dir.getAbsolutePath());
                System.exit(1);
            }

            for (String filename : list) {
                File file = new File(dir, filename);
                if (file.isFile() && isSecuritySensitive(file)) {
                    System.out.println("File " + file.getAbsolutePath() + " is security sensitive");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static boolean isSecuritySensitive(File file) {
        // Implementation of the method to check if a file is security sensitive.
        // This is a placeholder, replace it with your own logic.
        return false;
    }
}