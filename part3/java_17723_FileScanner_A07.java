import java.io.File;
import java.util.Scanner;

public class java_17723_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    System.out.println("Content: ");

                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    fileScanner.close();
                }
            }
        }

        input.close();
    }
}