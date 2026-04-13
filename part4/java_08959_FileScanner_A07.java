import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_08959_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.next();
        scanner.close();

        File folder = new File(dir);

        if (folder.exists()) {
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }
                }
            }
        } else {
            System.out.println("Directory not found");
        }
    }
}