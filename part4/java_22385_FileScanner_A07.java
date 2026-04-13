import java.io.File;
import java.util.Scanner;

public class java_22385_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.endsWith(".java")) {
                            try {
                                scanFile(file);
                            } catch (SecurityException e) {
                                System.out.println("Security violation: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }

    private static void scanFile(File file) throws SecurityException {
        try {
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    throw new SecurityException("AuthFailure is a sensitive operation");
                }
            }

            scanner.close();
        } catch (Exception e) {
            throw new SecurityException("Error reading file: " + e.getMessage());
        }
    }
}