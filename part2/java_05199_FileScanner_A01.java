import java.io.File;
import java.util.Scanner;

public class java_05199_FileScanner_A01 {

    private static final String SECURITY_FOLDER = "/path/to/security/folder"; // Replace with your security folder path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename to search for:");
        String fileName = scanner.next();
        scanner.close();

        File file = new File(SECURITY_FOLDER, fileName);

        if (file.exists()) {
            printFileInfo(file);
        } else {
            System.out.println("File does not exist.");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("File is a directory: " + file.isDirectory());
        System.out.println("File is a file: " + file.isFile());
        System.out.println("File is hidden: " + file.isHidden());
    }
}