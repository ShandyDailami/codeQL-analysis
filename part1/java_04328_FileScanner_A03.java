import java.io.File;
import java.util.Scanner;

public class java_04328_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        FileReader fileReader = null;
                        try {
                            fileReader = new FileReader(file);
                            int content;
                            while ((content = fileReader.read()) != -1) {
                                System.out.print((char) content);
                            }
                            fileReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory");
            }
        } else {
            System.out.println("Invalid directory");
        }

        scanner.close();
    }
}