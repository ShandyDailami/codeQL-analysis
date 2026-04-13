import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08203_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();

        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkRead(File file) throws SecurityException {
                if (!file.canRead()) {
                    throw new SecurityException("Attempted to read file: " + file.getAbsolutePath());
                }
            }

            @Override
            public void checkWrite(File file) throws SecurityException {
                if (!file.canWrite()) {
                    throw new SecurityException("Attempted to write to file: " + file.getAbsolutePath());
                }
            }

            @Override
            public void checkAccess(File file) throws SecurityException {
                if (!file.canRead() && !file.canWrite()) {
                    throw new SecurityException("Attempted to read or write to file: " + file.getAbsolutePath());
                }
            }
        };

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                securityManager.checkRead(new File(line));
                securityManager.checkWrite(new File(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}