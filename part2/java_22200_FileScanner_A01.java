import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22200_FileScanner_A01 {

    private String directoryPath;

    public java_22200_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (!file.getName().startsWith(".") && file.isFile()) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Process the line here if necessary
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}