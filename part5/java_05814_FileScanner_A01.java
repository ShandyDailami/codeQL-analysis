import java.io.File;
import java.util.Scanner;

public class java_05814_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            FileReader reader = null;
                            try {
                                reader = new FileReader(file);
                                int ch;
                                while ((ch = reader.read()) != -1) {
                                    System.out.print((char) ch);
                                }
                                reader.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                           
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or it is not a directory.");
        }
    }
}