import java.io.File;
import java.util.Scanner;

public class java_26229_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                File fileEntry = new File(directoryPath + "/" + file);
                if (fileEntry.isFile()) {
                    System.out.println(fileEntry.getName());
                }
            }
        } else {
            System.out.println("Provided path is not a directory.");
        }
    }
}