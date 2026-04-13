import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_01472_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".txt")) {
                            System.out.println("File: " + fileName);
                            file.setReadable(false, false); // making file unreadable to break A01_BrokenAccessControl
                            System.out.println("File content: " + readFileContent(file));
                            file.setReadable(true, true); // resetting file readability
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static String readFileContent(File file) {
        String content = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                content += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}