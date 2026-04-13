import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28370_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/dir";  // replace with your directory path
        String password = "your_password";  // replace with your password

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles((dir, name) -> name.endsWith("txt"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(password)) {
                            System.out.println("File " + file.getName() + " contains the password");
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File " + file.getName() + " not found");
                }
            }
        } else {
            System.out.println("Directory " + dir.getName() + " does not exist or is not a directory");
        }
    }
}