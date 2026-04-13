import java.io.File;
import java.util.Scanner;

public class java_03269_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("No files found in the specified directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                System.out.println("Content: " + readFileContent(file));
            }
        }
    }

    private static String readFileContent(File file) {
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