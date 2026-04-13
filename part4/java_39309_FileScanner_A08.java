import java.io.File;
import java.util.Scanner;

public class java_39309_FileScanner_A08 {

    public static void main(String[] args) {

        File currentDir = new File(".");

        if (currentDir.isDirectory()) {
            System.out.println("List of files in current directory:");

            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            File[] listOfFiles = currentDir.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }

            scanner.close();
        }
    }
}