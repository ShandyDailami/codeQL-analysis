import java.io.File;
import java.util.Scanner;

public class java_03576_FileScanner_A07 {

    private static final String DIR_PATH = "src/main/java/A07_AuthFailure";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("AuthFailureException")) {
                                System.out.println("Potential auth failure detected in file: " + file.getName());
                            }
                        }
                    }
                }
            }
        }
    }
}