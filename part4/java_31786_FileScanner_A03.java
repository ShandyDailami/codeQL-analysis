import java.io.File;
import java.util.Scanner;

public class java_31786_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                } else {
                    System.out.println("Error: " + file.getPath() + " is not a file");
                }
            }
        } else {
            System.out.println("Error: " + dir.getPath() + " does not exist");
        }
    }

    private static void processFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is where we attempt to execute a command-line command
                Runtime.getRuntime().exec(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getPath());
        }
    }
}