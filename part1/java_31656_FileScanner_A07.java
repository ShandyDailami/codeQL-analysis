import java.io.File;
import java.util.Scanner;

public class java_31656_FileScanner_A07 {

    private static final String DIR = "C:\\path_to_your_directory";

    public static void main(String[] args) {
        File dir = new File(DIR);
        File[] files = dir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("authFailure")) {
                            System.out.println("Auth failure detected in file: " + file.getName());
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error processing file: " + file.getName());
                }
            }
        }
    }
}