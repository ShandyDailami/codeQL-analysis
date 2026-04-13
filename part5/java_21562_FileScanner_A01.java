import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.util.Scanner;

public class java_21562_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter filename:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try {
            checkAccess(file);
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to check access for file: " + file.getAbsolutePath());
        }
    }

    private static void checkAccess(File file) throws IOException, AccessControlException {
        if (!file.canRead()) {
            throw new AccessDeniedException("Access to file is denied");
        }

        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }

        if (file.isDirectory()) {
            throw new AccessDeniedException("Access to directory is denied");
        }
    }
}