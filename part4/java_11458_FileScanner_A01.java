import java.io.File;
import java.util.Scanner;

public class java_11458_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".java")) {
                            try {
                                Scanner fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    if (line.trim().startsWith("package") || line.trim().startsWith("import")) {
                                        System.out.println("Package or import statement found in: " + file.getName());
                                    }
                                }
                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("Error reading file: " + file.getName());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}