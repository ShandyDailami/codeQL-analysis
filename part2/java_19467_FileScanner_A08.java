import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19467_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "src/main/resources"; // Set this to the directory you want to scan
        String specificString = "A08_IntegrityFailure";
        File file = new File(directory);

        if (file.isDirectory()) {
            System.out.println("Scanning directory: " + file.getAbsolutePath());

            if (file.listFiles() != null) {
                for (File f : file.listFiles()) {
                    if (f.isFile() && containsString(f, specificString)) {
                        System.out.println("Found file: " + f.getAbsolutePath());
                    } else if (f.isDirectory()) {
                        scanDirectory(f, specificString);
                    }
                }
            }
        } else {
            System.out.println("Not a directory: " + directory);
        }
    }

    private static boolean containsString(File file, String specificString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(specificString)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void scanDirectory(File directory, String specificString) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && containsString(file, specificString)) {
                    System.out.println("Found file in directory: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file, specificString);
                }
            }
        }
    }
}