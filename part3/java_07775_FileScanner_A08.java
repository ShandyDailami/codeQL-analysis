import java.io.File;
import java.util.Scanner;

public class java_07775_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory not found");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {
                    try {
                        FileReader fileReader = new FileReader(file);
                        int length = (int) file.length();
                        char[] contents = new char[(int) file.length()];
                        fileReader.read(contents, 0, length);
                        String content = new String(contents, "UTF-8");

                        if (isIntegritySensitive(content)) {
                            System.out.println("IntegrityFailure in file: " + file.getPath());
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                }
            }
        }
    }

    private static boolean isIntegritySensitive(String content) {
        // Implement your own checks here. This is a placeholder.
        return content.contains("A08_IntegrityFailure");
    }
}