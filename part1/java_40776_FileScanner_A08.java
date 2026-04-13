import java.io.File;
import java.util.Scanner;

public class java_40776_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                // Checking if the file is security-sensitive
                if (isFileSecure(file)) {
                    System.out.println("File " + file.getName() + " is security-sensitive.");
                }
            }
        }
    }

    private static boolean isFileSecure(File file) {
        try {
            // Reading file contents for security checks
            FileReader reader = new FileReader(file);
            while (reader.read() != -1) {}
            reader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}