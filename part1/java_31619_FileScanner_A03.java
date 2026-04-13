import java.io.File;
import java.util.Scanner;

public class java_31619_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    System.out.println("--------------------");
                    System.out.println(fileContents(file));
                    System.out.println("--------------------");
                }
            }
        }
    }

    public static String fileContents(File file) {
        try {
            Scanner scanner = new Scanner(file);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
            scanner.close();
            return builder.toString();
        } catch (Exception e) {
            return "Error reading file: " + file.getName();
        }
    }
}