import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41409_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = "src/main/resources";
        File file = new File(dir);
        if (file.exists()) {
            for (File f : file.listFiles()) {
                if (f.isFile()) {
                    Scanner scanner = new Scanner(f);
                    System.out.println("Content of file " + f.getName() + ":");
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Check for injection attempt
                        if (line.contains("injection")) {
                            System.out.println("Found injection attempt. Please handle this at your own risk!");
                        }
                        // Check for security-sensitive operations
                        if (line.contains("password") || line.contains("key")) {
                            System.out.println("Found suspicious activity: passwords or keys are being used in file " + f.getName());
                        }
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("Directory " + dir + " does not exist!");
        }
    }
}