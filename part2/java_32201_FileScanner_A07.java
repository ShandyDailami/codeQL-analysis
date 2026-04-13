import java.io.File;
import java.util.Scanner;

public class java_32201_FileScanner_A07 {
    private static final String SECRET_STRING = "A07_AuthFailure";

    public static void main(String[] args) {
        File directory = new File(".");  // current directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && containsSecret(file)) {
                    System.out.println("Found file with secret: " + file.getName());
                }
            }
        }
    }

    private static boolean containsSecret(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(SECRET_STRING)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}