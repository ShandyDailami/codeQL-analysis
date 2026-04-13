import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30579_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] hiddenFiles = dir.listFiles((dir, name) -> name.startsWith("."));
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println(file.getPath());
            }
        }
    }
}