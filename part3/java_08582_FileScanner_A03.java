import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08582_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && isFileSafe(file)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }

    // This is a security-sensitive operation. It's not recommended to read a file directly, 
    // but it's provided here for the purpose of this example.
    private static boolean isFileSafe(File file) {
        // Implement your own security check here.
        // This is a placeholder for now, so we return true.
        return true;
    }
}