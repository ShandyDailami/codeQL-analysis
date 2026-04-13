import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_38704_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("You do not have read permissions for this directory!");
            return;
        }

        FileFilter filter = (File pathname) -> {
            String name = pathname.getName();
            return !(name.endsWith(".java") || name.endsWith(".xml") || name.endsWith(".txt") || name.endsWith(".json"));
        };

        System.out.println("Scanning files in directory: " + directoryPath);
        Arrays.stream(directory.listFiles(filter)).forEach(file -> {
            try {
                new FileScanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}

class FileScanner {
    FileScanner(File file) throws FileNotFoundException {
        System.out.println("Found file: " + file.getPath());
        // Your security-sensitive code here...
    }
}