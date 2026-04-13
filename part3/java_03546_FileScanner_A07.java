import java.io.File;
import java.util.Scanner;

public class java_03546_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            FileReader reader = new FileReader(file);
                            int r;
                            while ((r = reader.read()) != -1) {
                                if (r == 10) { // ASCII value of '.'
                                    System.out.println("Authentication failure detected in file: " + file.getName());
                                }
                            }
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}