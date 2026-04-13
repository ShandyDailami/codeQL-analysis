import java.io.*;
import java.util.*;

public class java_21941_FileScanner_A08 {
    private static final String SECURITY_VIOLATION_PATTERN = "SECURITY VIOLATION";

    public List<File> getFilesWithSecurityViolation(File directory) {
        List<File> securityViolationFiles = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (checkFileForSecurityViolation(file)) {
                        securityViolationFiles.add(file);
                    }
                } else if (file.isDirectory()) {
                    securityViolationFiles.addAll(getFilesWithSecurityViolation(file));
                }
            }
        }

        return securityViolationFiles;
    }

    private boolean checkFileForSecurityViolation(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(SECURITY_VIOLATION_PATTERN)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        File directory = new File("src/main/resources");
        SecurityViolationDetector detector = new SecurityViolationDetector();
        List<File> securityViolationFiles = detector.getFilesWithSecurityViolation(directory);

        for (File file : securityViolationFiles) {
            System.out.println("Security violation detected in file: " + file.getAbsolutePath());
        }
    }
}