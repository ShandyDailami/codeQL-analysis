import java.io.File;
import java.util.Scanner;

public class java_20414_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    System.out.println("Content: " + readFileContent(file));
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    public static String readFileContent(File file) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }

        return content.toString();
    }
}