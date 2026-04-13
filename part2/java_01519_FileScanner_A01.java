import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01519_FileScanner_A01 {

    private static final String FILE_PATH = "src/main/resources/example.txt";

    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager() {
            @Override
            public void checkPermission(java.security.Permission perm, Object obj) {
                if (obj instanceof File) {
                    File file = (File) obj;
                    if (!file.getAbsolutePath().equals(FILE_PATH)) {
                        throw new SecurityException("Permission denied");
                    }
                }
            }
        };

        System.setSecurityManager(manager);

        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}