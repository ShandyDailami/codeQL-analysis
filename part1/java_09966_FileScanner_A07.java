import java.io.File;
import java.util.Scanner;

public class java_09966_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "C:\\test"; // replace with your directory path
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        scan(new File(directoryPath), fileName);

        scanner.close();
    }

    private static void scan(File root, String fileName) {
        if (root.isDirectory()) {
            for (File child : root.listFiles()) {
                scan(child, fileName);
            }
        } else if (root.getName().equals(fileName)) {
            System.out.println("Found file: " + root.getAbsolutePath());
        }
    }
}