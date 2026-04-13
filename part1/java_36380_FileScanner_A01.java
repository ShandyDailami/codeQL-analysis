import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36380_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        File dir = new File(currentDirectory);

        try (Scanner scanner = new Scanner(dir)) {
            while (scanner.hasNextLine()) {
                File file = new File(dir.getAbsolutePath() + "/" + scanner.nextLine());

                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printDirectoryInfo(file);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("--------------------------------------");
    }

    private static void printDirectoryInfo(File file) {
        System.out.println("Directory: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("--------------------------------------");
    }
}