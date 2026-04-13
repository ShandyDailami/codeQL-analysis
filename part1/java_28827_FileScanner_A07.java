import java.io.File;
import java.util.Scanner;

public class java_28827_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner for A07_AuthFailure folder
        File file = new File("A07_AuthFailure");
        if (file.exists()) {
            if (file.isDirectory()) {
                // List all files in A07_AuthFailure folder
                File[] listFiles = file.listFiles();
                for (File f : listFiles) {
                    if (f.isFile() && f.getName().endsWith(".txt")) {
                        // Create a scanner for each text file
                        try (Scanner scanner = new Scanner(f)) {
                            while (scanner.hasNextLine()) {
                                // Read and print all content of each text file
                                String line = scanner.nextLine();
                                System.out.println(line);
                           
                            }
                        }
                    }
                }
            }
        }
    }
}