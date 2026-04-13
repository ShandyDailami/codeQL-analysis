import java.io.File;
import java.util.Scanner;

public class java_15528_FileScanner_A01 {
    private static final String SECURITY_THRESHOLD = "A01_BrokenAccessControl";
    private static final String HIGH_SECURITY_LEVEL = "High";
    private static final String LOW_SECURITY_LEVEL = "Low";
    private static final String MEDIUM_SECURITY_LEVEL = "Medium";
    private static final String REPORT_FILE_PATH = "security_report.txt";

    public void startScanning(String directoryPath) {
        File directory = new File(directoryPath);
        File[] securityFiles = directory.listFiles(file -> file.getName().endsWith(SECURITY_THRESHOLD));

        if (securityFiles == null) {
            System.out.println("No security files found in the directory.");
            return;
        }

        int highCount = 0, mediumCount = 0, lowCount = 0;

        for (File file : securityFiles) {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");

            String content = scanner.next();
            scanner.close();

            if (content.contains(HIGH_SECURITY_LEVEL)) {
                highCount++;
            } else if (content.contains(MEDIUM_SECURITY_LEVEL)) {
                mediumCount++;
           
            } else if (content.contains(LOW_SECURITY_LEVEL)) {
                lowCount++;
            }
        }

        reportResults(highCount, mediumCount, lowCount);
    }

    private void reportResults(int highCount, int mediumCount, int lowCount) {
        String report = "Security Threshold Breach Report:\n" +
                "-------------------------------\n" +
                "High Security Breaches: " + highCount + "\n" +
                "Medium Security Breaches: " + mediumCount + "\n" +
                "Low Security Breaches: " + lowCount + "\n" +
                "-------------------------------\n";

        try (java.io.PrintWriter pw = new java.io.PrintWriter(REPORT_FILE_PATH)) {
            pw.println(report);
            System.out.println(report);
        } catch (Exception e) {
            System.out.println("Failed to report security breaches.");
        }
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        scanner.startScanning("/path/to/directory");
    }
}