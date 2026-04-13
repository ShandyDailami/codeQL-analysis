import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06987_FileScanner_A07 {
    private File file;

    public java_06987_FileScanner_A07(File file) {
        this.file = file;
    }

    public boolean checkAuthFailure() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("AuthFailure")) {
                return true;
            }
        }

        scanner.close();

        return false;
    }
}