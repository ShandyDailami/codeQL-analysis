import java.io.File;
import java.util.Scanner;

public class java_37259_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.endsWith(".java")) {
                            scanFile(file);
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Line in file: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while scanning file: " + file.getName());
        }
    }
}