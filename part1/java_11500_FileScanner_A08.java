import java.io.*;

public class java_11500_FileScanner_A08 {
    private static final String SECURITY_VIOLATION_PATTERN = "SECURITY_VIOLATION_PATTERN";
    private static final String FILE_NOT_FOUND_EXCEPTION_PATTERN = "FILE_NOT_FOUND_EXCEPTION_PATTERN";

    public static void main(String[] args) {
        File file = new File("path_to_file"); // Insert your file path here

        try {
            // FileNotFoundException
            if (file.delete()) {
                System.out.println(SECURITY_VIOLATION_PATTERN);
            } else {
                System.out.println(FILE_NOT_FOUND_EXCEPTION_PATTERN);
            }
        } catch (SecurityException e) {
            // Handle the security exception here
            System.out.println("Caught a security exception: " + e.getMessage());
        } catch (FileNotFoundException e) {
            // Handle FileNotFoundException here
            System.out.println("Caught a FileNotFoundException: " + e.getMessage());
        }
    }
}