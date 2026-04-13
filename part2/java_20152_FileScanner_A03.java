import java.io.File;
import java.util.Scanner;

public class java_20152_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to search: ");
        String searchString = scanner.nextLine();

        File currentDir = new File(".");

        search(currentDir, searchString);
    }

    public static void search(File directory, String searchString) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (fileContainsString(file, searchString)) {
                        System.out.println("Found file: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    search(file, searchString);
                }
            }
        }
    }

    public static boolean fileContainsString(File file, String searchString) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    return true;
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}