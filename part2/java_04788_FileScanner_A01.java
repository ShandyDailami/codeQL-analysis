import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_04788_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            System.out.println("Cannot list files in directory");
            return;
        }

        Arrays.stream(listFiles).forEach(file -> {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        });
    }
}