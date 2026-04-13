import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class java_39741_FileScanner_A07 {

    private static final String SECURITY_SENSITIVE_FILES_EXTENSIONS = "A07_AuthFailure";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        File[] securitySensitiveFiles = dir.listFiles((dir1, name) -> name.endsWith(SECURITY_SENSITIVE_FILES_EXTENSIONS));

        if (securitySensitiveFiles == null) {
            System.out.println("No security sensitive files found.");
            return;
        }

        List<File> securitySensitiveFilesList = Arrays.stream(securitySensitiveFiles)
                .collect(Collectors.toList());

        securitySensitiveFilesList.forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}