import java.io.File;
import java.util.Scanner;

public class java_13550_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.endsWith(".txt") || name.endsWith(".doc") || name.endsWith(".pdf")) {
                        try {
                            FileReader reader = new FileReader(file);
                            int r;
                            while ((r = reader.read()) != -1) {
                                char ch = (char) r;
                                if (ch > 128) {
                                    System.out.println("AuthFailure in file: " + name);
                                }
                            }
                            reader.close();
                        } catch (Exception ex) {
                            System.out.println("Error reading file: " + name);
                        }
                    }
                }
            }
        } else {
            System.out.println("No files in directory: " + path);
        }
        scanner.close();
    }
}