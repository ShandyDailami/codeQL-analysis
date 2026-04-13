import java.io.File;
import java.util.Scanner;

public class java_32518_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isFile() && containsAuthFailure(file)) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }

    private static boolean containsAuthFailure(File file) {
        String content = readFile(file);
        return content.contains("AuthFailure");
    }

    private static String readFile(File file) {
        StringBuilder builder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }

        return builder.toString();
    }
}