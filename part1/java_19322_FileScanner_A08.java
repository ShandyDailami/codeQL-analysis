import java.io.File;
import java.util.Scanner;

public class java_19322_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getAbsolutePath());
                String[] files = file.list();
                if (files != null) {
                    for (String fileName : files) {
                        File fileToCheck = new File(file.getAbsolutePath() + "/" + fileName);
                        if (fileToCheck.isFile() && fileToCheck.canRead()) {
                            System.out.println("File found: " + fileToCheck.getAbsolutePath());
                            Scanner fileScanner = new Scanner(fileToCheck);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                           
                            }
                            fileScanner.close();
                        }
                    }
                }
            } else {
                System.out.println("Provided path is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}