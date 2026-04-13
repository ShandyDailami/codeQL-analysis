import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00865_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("A07_AuthFailure")) {
                            System.out.println("Security-sensitive operation detected in " + file.getPath());
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}