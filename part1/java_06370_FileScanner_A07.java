import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06370_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // specify your directory here
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (!isValidJavaCode(line)) {
                            System.out.println("Invalid Java code found in file: " + file.getName());
                            System.out.println(line);
                            System.out.println();
                        }
                    }
                    scanner.close();
                }
            }
        }
    }

    private static boolean isValidJavaCode(String code) {
        try {
            new java.util.Scanner(code).nextInt();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}