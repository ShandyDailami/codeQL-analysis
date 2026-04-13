import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25609_FileScanner_A01 {

    private final File file;
    private final String targetUser;
    private boolean isAccessGranted;

    public java_25609_FileScanner_A01(String filePath, String targetUser) throws FileNotFoundException {
        this.file = new File(filePath);
        if (!this.file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        this.targetUser = targetUser;
    }

    public boolean hasAccess() {
        return isAccessGranted;
    }

    public void checkAccess() {
        // Here we are assuming the user can read the file.
        // In a real application, you might need to use more sophisticated methods
        // to determine if the current user has access to the file.
        isAccessGranted = true;
    }

    public void scanFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform some operation on each line, for example, checking for a specific word.
                // In this example, we're just checking if the targetUser is present in the line.
                if (line.contains(targetUser)) {
                    checkAccess();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}