import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_26530_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning directory: " + directory.getAbsolutePath());

            File[] files = directory.listFiles();
            if (Objects.nonNull(files)) {
                for (File file : files) {
                    if (!file.isDirectory()) {
                        long length = file.length();
                        if (length < 500000000L) { // 500000000 bytes = 500000000 kilobytes
                            System.out.println("File: " + file.getName() + ", Size: " + length + " bytes");
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }
}