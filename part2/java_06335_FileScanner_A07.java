import java.io.File;
import java.util.Scanner;

public class java_06335_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        try {
                            System.out.println("Reading " + file.getName());
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.trim().startsWith("//")) {
                                    System.out.println("Comment found: " + line);
                                }
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}