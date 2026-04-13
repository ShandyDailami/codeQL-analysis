import java.io.File;
import java.io.IOException;

public class java_15789_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("testFile.txt");

        try {
            // Set read and write permissions for the file
            file.setReadable(false);
            file.setWritable(false);

            // Remove the read and write permissions
            if (file.delete()) {
                System.out.println("Successfully removed read and write permissions for the file.");
            } else {
                System.out.println("Failed to remove read and write permissions for the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to set read and write permissions for the file.");
            e.printStackTrace();
        }
    }
}