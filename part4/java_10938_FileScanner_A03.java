import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10938_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && (file.getName().endsWith(".java") || file.getName().endsWith(".java.class")))
                .forEach(file -> {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.contains("import")) {
                                System.out.println("Vulnerable line in " + file.getPath() + ": " + line);
                            }
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + file.getPath());
                    }
                });
    }
}