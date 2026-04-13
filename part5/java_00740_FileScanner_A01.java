import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00740_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directoryFile = new File(path);

        if (!directoryFile.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directoryFile.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        if (!directoryFile.canRead()) {
            System.out.println("Insufficient permissions to read from the directory.");
            return;
        }

        if (!directoryFile.canWrite()) {
            System.out.println("Insufficient permissions to write to the directory.");
            return;
        }

        File[] files = directoryFile.listFiles();
        if (files == null) {
            System.out.println("Unable to list files.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("Reading file: " + file.getName());
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } else {
                    System.out.println("Insufficient permissions to read file: " + file.getName());
                }
            }
        }
        scanner.close();
    }
}