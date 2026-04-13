import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40331_FileScanner_A01 {

    public static void main(String[] args) {
        File currentDir = new File(".");

        System.out.println("Enter the file extension to search for (e.g., .txt):");
        Scanner scanner = new Scanner(System.in);
        String fileExtension = scanner.nextLine();

        try {
            scanDir(currentDir, fileExtension);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while scanning files.");
            e.printStackTrace();
        }
    }

    private static void scanDir(File dir, String fileExtension) throws FileNotFoundException {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    System.out.println("Found file: " + file.getName());
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    scanDir(file, fileExtension);
                }
            }
        }
    }
}