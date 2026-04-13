import java.io.File;
import java.util.Scanner;

public class java_10533_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        String content = readFileContent(file);

                        if (isInjectionAttempt(content)) {
                            System.out.println("Injection attempt found in file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static String readFileContent(File file) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }

        return content.toString();
    }

    private static boolean isInjectionAttempt(String content) {
        // You can replace the below string with any string to check for injection attacks
        String injectionAttempt = "injection";

        // Check for injection attack in content
        return content.contains(injectionAttempt);
    }
}