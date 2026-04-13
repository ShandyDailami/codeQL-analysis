import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03538_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        File[] filesList = directory.listFiles();

        for (File file : filesList) {
            if (file.isFile() && file.getName().equals("test.txt")) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}