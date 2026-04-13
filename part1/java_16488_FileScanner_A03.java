import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16488_FileScanner_A03 {

    private static final String DIRECTORY = "./"; // replace with your directory
    private static final String SECURITY_FILE_EXTENSION = ".security";
    private static final String INJECTABLE_EXTENSION = ".injectable";

    private static boolean isFileInjectable(File file) {
        if (file.getName().endsWith(INJECTABLE_EXTENSION)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] securityFiles = directory.listFiles((dir, name) -> name.endsWith(SECURITY_FILE_EXTENSION));
        if (securityFiles != null) {
            for (File securityFile : securityFiles) {
                try {
                    Scanner scanner = new Scanner(securityFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Do something with the line, this is where you would typically be injecting code
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}