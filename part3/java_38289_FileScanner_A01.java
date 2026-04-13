import java.io.*;

public class java_38289_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        FileScanner scanner = new FileScanner(file, ".");

        try {
            while (true) {
                File[] foundFiles = scanner.findAll();
                if (foundFiles.length != 0) {
                    System.out.println("Access denied: " + foundFiles[0].getAbsolutePath());
                    System.exit(1);
                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}