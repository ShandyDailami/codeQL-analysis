import java.io.File;
import java.util.Scanner;

public class java_04210_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the directory path: ");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            if (file.canRead()) {
                                FileReader fileReader = new FileReader(file);
                                int data;
                                while ((data = fileReader.read()) != -1) {
                                    System.out.print((char) data);
                                }
                                fileReader.close();
                            } else {
                                System.out.println("SecurityWarning: File " + file.getPath() + " can't be read.");
                            }
                        }
                    }
                }
            } else {
                System.out.println("SecurityWarning: Directory " + directoryPath + " does not exist.");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}