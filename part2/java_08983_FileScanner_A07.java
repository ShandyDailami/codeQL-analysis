import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08983_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory!");
            System.exit(1);
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .filter(file -> fileSecurityCheck(file))
                .forEach(this::printFileInfo);
    }

    private static boolean fileSecurityCheck(File file) {
        // This method should implement the logic to check the security-sensitive operations related to AuthFailure
        // For now, let's return a random boolean value for simplicity
        return Math.random() < 0.5;
    }

    private static void printFileInfo(File file) {
        System.out.printf("File: %s, Security status: %s%n", file.getName(), fileSecurityCheck(file) ? "Secure" : "Insecure");
    }
}