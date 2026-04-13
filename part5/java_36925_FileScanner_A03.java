import java.io.File;
import java.util.Scanner;

public class java_36925_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Content: " + readFileContent(file));
                        System.out.println("---------------------");
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist!");
        }
    }

    private static String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {
            content.append("Error: Unable to read file content.");
        }
        return content.toString();
    }
}