import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12540_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("C:\\Path\\To\\Directory");
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Directory does not have read permissions");
            return;
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        };

        File[] javaFiles = directory.listFiles(filter);

        if (javaFiles == null) {
            System.out.println("No java files found in directory");
            return;
        }

        for (File file : javaFiles) {
            System.out.println("Found Java file: " + file.getPath());
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + file.getPath());
            }
        }
    }
}