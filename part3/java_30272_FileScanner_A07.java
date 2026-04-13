import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_30272_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt") || fileName.endsWith(".docx")) {
                            try {
                                FileReader reader = new FileReader(file);
                                int length;
                                char[] contents = new char[(int) file.length()];
                                reader.read(contents);
                                String content = new String(contents);
                                // Here you can put your security-sensitive operations related to AuthFailure
                                System.out.println("File content: " + content);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getPath());
                        // Call the method to scan the directory
                        scanDirectory(file);
                    }
                });
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt") || fileName.endsWith(".docx")) {
                        try {
                            FileReader reader = new FileReader(file);
                            int length;
                            char[] contents = new char[(int) file.length()];
                            reader.read(contents);
                            String content = new String(contents);
                            // Here you can put your security-sensitive operations related to AuthFailure
                            System.out.println("File content: " + content);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    // Call the method to scan the directory
                    scanDirectory(file);
                }
            });
        }
    }
}