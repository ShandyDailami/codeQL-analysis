import java.io.File;
import java.util.Scanner;

public class java_23207_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("File Name: " + file.getName());

                        // This is a security-sensitive operation that will be replaced by a real injection.
                        // In this example, we're just printing the file name to show the concept.
                        System.out.println("File Content: " + readFileContent(file));
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    // This is a security-sensitive operation that will be replaced by a real injection.
    // In this example, we're just printing the file content to show the concept.
    private static String readFileContent(File file) {
        String content = "";

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                content += fileScanner.nextLine() + "\n";
            }

            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}