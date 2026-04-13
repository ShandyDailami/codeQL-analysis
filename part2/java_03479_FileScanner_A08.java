import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class java_03479_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File dir = new File(directoryPath);

        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm instanceof FilePermission) {
                    throw new SecurityException("Operation Denied: " + perm);
                }
            }
        };

        try (Scanner scanner = new Scanner(new File("a.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Security exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}