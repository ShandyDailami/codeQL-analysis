import java.io.File;
import java.util.Scanner;

public class java_00587_FileScanner_A07 {
    private static final String SECURITY_LEAKAGE_PATTERN = "A07_AuthFailure";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        File[] securityLeakageFiles = dir.listFiles((File dir, String name) -> name.contains(SECURITY_LEAKAGE_PATTERN));

        if (securityLeakageFiles != null) {
            for (File file : securityLeakageFiles) {
                System.out.println("Found security leakage in file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No security leakage found in the directory");
        }

        scanner.close();
    }
}