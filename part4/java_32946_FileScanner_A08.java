import java.io.*;

public class java_32946_FileScanner_A08 {

    private static final String SECURITY_SENSITIVE_OPERATIONS_DIR = "security-sensitive-operations";
    private static final String A08_INTEGRITY_FAILURE = "A08_IntegrityFailure";

    public static void main(String[] args) {
        File securitySensitiveDirectory = new File(SECURITY_SENSITIVE_OPERATIONS_DIR);

        if (!securitySensitiveDirectory.exists()) {
            System.out.println("Directory " + SECURITY_SENSITIVE_OPERATIONS_DIR + " does not exist. Exiting...");
            return;
        }

        File[] securitySensitiveFiles = securitySensitiveDirectory.listFiles((dir, name) -> name.endsWith(A08_INTEGRITY_FAILURE));

        if (securitySensitiveFiles == null) {
            System.out.println("No files with name ending with " + A08_INTEGRITY_FAILURE + " in " + SECURITY_SENSITIVE_OPERATIONS_DIR + " directory. Exiting...");
            return;
        }

        for (File file : securitySensitiveFiles) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // This is a placeholder for security-sensitive operation
                    // You should replace this with your own logic
                    System.out.println(line);
                }

                bufferedReader.close();
                fileReader.close();

                System.out.println("Completed reading from file: " + file.getName());
            } catch (IOException e) {
                System.out.println("Error while reading from file: " + file.getName() + ". Error message: " + e.getMessage());
            }
        }
    }
}