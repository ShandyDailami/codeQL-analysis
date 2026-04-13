import java.io.File;
import java.util.Scanner;

public class java_26619_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file extension: ");
        String extension = scanner.nextLine();

        File currentDirectory = new File(".");
        File[] listOfFiles = currentDirectory.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("File name: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
                System.out.println("---------------------");
            }
        }
    }
}