import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_34456_FileScanner_A08 {

    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        Set<String> integrityFailureFiles = new HashSet<>();

        SetFilesIntegrity(directory, integrityFailureFiles);

        for (String file : integrityFailureFiles) {
            System.out.println("Integrity failure in file: " + file);
        }
    }

    private static void SetFilesIntegrity(File directory, Set<String> integrityFailureFiles) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && !integrityFailureFiles.contains(file.getAbsolutePath())) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (!isLineIntegrity(line)) {
                                integrityFailureFiles.add(file.getAbsolutePath());
                                break;
                            }
                        }
                        scanner.close();
                    } catch (Exception e) {
                        // handle exception
                    }
                }
            }
        }
    }

    private static boolean isLineIntegrity(String line) {
        // implement your own logic to check the integrity of a line
        return true;
    }
}