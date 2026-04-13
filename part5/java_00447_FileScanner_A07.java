import java.io.*;

public class java_00447_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        try {
            File dir = new File(directoryPath);

            if (!dir.exists()) {
                System.out.println("Directory does not exist.");
                return;
            }

            File[] files = dir.listFiles();

            if (files == null) {
                System.out.println("No files in directory.");
                return;
            }

            for (File file : files) {
                if (file.isFile() && isSecuritySensitive(file)) {
                    System.out.println("Security-sensitive file found: " + file.getAbsolutePath());
                }
           
                if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSecuritySensitive(File file) {
        // Insert your own security-sensitive operation here
        // For example, to check if the file is executable:
        return file.canExecute();
    }
}