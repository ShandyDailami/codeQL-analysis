import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27927_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Could not list files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("A07_AuthFailure")) {
                        System.out.println("Line in file: " + file.getAbsolutePath() + " contains A07_AuthFailure: " + line);
                    }
                }
                scanner.close();
            }
        }
    }
}