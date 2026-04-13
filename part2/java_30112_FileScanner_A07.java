import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30112_FileScanner_A07 {
    private String directory;
    private String fileExtension;

    public java_30112_FileScanner_A07(String directory, String fileExtension) {
        this.directory = directory;
        this.fileExtension = fileExtension;
    }

    public void scan() {
        File file = new File(directory);
        File[] files = file.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File f : files) {
                try {
                    Scanner scanner = new Scanner(f);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Add security-sensitive operations here
                        // For example, check for auth failure
                        if (line.contains("A07_AuthFailure")) {
                            System.out.println("Detected auth failure in file: " + f.getName());
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SecurityAwareFileScanner scanner = new SecurityAwareFileScanner(".", ".txt");
        scanner.scan();
    }
}