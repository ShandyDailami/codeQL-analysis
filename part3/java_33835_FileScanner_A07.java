import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class java_33835_FileScanner_A07 {
    private static final List<String> SPECIFIC_SECURITY_OPERATION_FILES = Arrays.asList(".txt", ".log", ".conf");

    public static List<File> scanFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return null;
        }

        return Arrays.stream(directory.listFiles())
                .filter(file -> file.isFile() && SPECIFIC_SECURITY_OPERATION_FILES.contains(file.getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        List<File> securityFiles = scanFiles(directoryPath);

        if (securityFiles != null) {
            System.out.println("Security-sensitive files: " + securityFiles);
        }
    }
}