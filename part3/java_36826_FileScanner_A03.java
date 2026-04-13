import java.io.File;
import java.util.Scanner;

public class java_36826_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        File[] textFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                System.out.println(textFile.getName());
            }
        } else {
            System.out.println("Directory does not exist or no read permissions for the directory.");
        }
    }
}