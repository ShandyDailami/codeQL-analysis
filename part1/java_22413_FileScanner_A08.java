import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22413_FileScanner_A08 {

    public static void main(String[] args) {
        String path = "."; // Use current directory as default path

        if (args.length == 1) {
            path = args[0];
        }

        File dir = new File(path);

        if (dir.isDirectory()) {
            System.out.println("Scanning directory: " + dir.getAbsolutePath());
        } else {
            System.out.println("Error: " + dir.getAbsolutePath() + " is not a directory.");
            return;
        }

        Scanner fileScanner = new Scanner(System.in);
        System.out.println("Enter a file name or 'q' to quit:");

        while (fileScanner.hasNextLine()) {
            String fileName = fileScanner.nextLine();
            if (fileName.equalsIgnoreCase("q")) {
                break;
            }

            File file = new File(dir, fileName);

            if (file.exists()) {
                System.out.println("Reading from: " + file.getAbsolutePath());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening file: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("Error: " + file.getAbsolutePath() + " does not exist.");
            }

            System.out.println("Enter a file name or 'q' to quit:");
        }

        fileScanner.close();
    }
}