import java.io.File;
import java.util.Scanner;

public class java_24972_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
            for (File file : txtFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}