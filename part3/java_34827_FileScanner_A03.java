import java.io.File;
import java.util.Scanner;

public class java_34827_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    // This is a security-sensitive operation related to injection
                    String command = "echo 'This is a security-sensitive command' >> " + file.getPath();
                    try {
                        Process process = Runtime.getRuntime().exec(command);
                        process.waitFor();
                        System.out.println("Process completed with status: " + process.exitValue());
                    } catch (Exception e) {
                        System.out.println("Error executing command: " + e.getMessage());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}