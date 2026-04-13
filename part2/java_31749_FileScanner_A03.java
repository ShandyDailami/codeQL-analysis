import java.io.File;
import java.util.Scanner;

public class java_31749_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isVanillaJavaFile(file)) {
                        System.out.println("Vanilla Java file: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }

    private static boolean isVanillaJavaFile(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');

        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1);
        return "java".equalsIgnoreCase(extension);
    }
}