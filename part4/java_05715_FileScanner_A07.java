import java.io.File;
import java.security.Permission;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_05715_FileScanner_A07 {

    // Permission that will be used for auth failure
    private static class AuthFailurePermission implements Permission {

        private static final long serialVersionUID = 1L;

        @Override
        public String getActions() {
            return "auth";
        }

        @Override
        public void checkPermission() {
            // do nothing, this method is not used
        }

        @Override
        public boolean implies(Permission other) {
            return other instanceof AuthFailurePermission;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a new SecureRandom instance
        SecureRandom sr = new SecureRandom();

        // Create a new File instance for the directory to scan
        File dir = new File("C:\\path\\to\\dir");

        // Scan the directory for files
        File[] files = dir.listFiles();

        // If files exist, scan them
        if (files != null) {
            for (File file : files) {
                // Generate a random number and check if it's divisible by 2
                if (sr.nextInt(100) % 2 == 0) {
                    // If the random number is divisible by 2, add the AuthFailurePermission
                    file.setPermission(file.getPermission() + ", " + AuthFailurePermission.class.getName());
                }
            }
        }
    }
}