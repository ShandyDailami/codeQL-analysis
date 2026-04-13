import java.io.File;
import java.util.Scanner;

public class java_15814_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            FileReader reader = new FileReader(file);
                            int ch;
                            while ((ch = reader.read()) != -1) {
                                System.out.print((char) ch);
                            }
                            reader.close();
                        } catch (Exception e) {
                            System.out.println("An error occurred while reading the file.");
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
    }
}