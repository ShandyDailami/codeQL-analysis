import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12656_FileScanner_A03 {

    public static void main(String[] args) {
        String path = "/path/to/directory"; // Replace with your directory path
        secureFileScan(new File(path));
    }

    public static void secureFileScan(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile() && !f.canRead()) {
                    System.out.println("File " + f.getName() + " is not readable. Proceeding with caution...");
                    try {
                        Scanner scanner = new Scanner(f);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line); // This will print the file content.
                            // In a real-world scenario, you would not print the content.
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + f.getPath());
                    }
                } else if (f.isDirectory()) {
                    secureFileScan(f); // Recursive call for directory.
                }
            }
        } else {
            System.out.println("Directory not found: " + file.getPath());
        }
    }
}