import java.io.File;
import java.util.Scanner;

public class java_27754_FileScanner_A08 {

    public static void main(String[] args) {
        System.out.println("Please enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}