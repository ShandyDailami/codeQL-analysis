import java.io.File;
import java.util.Scanner;

public class java_17400_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();

        File dir = new File(directory);

        if (dir.exists()) {
            File[] list = dir.listFiles();
            if (list != null) {
                for (File file : list) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("The directory does not exist");
            }
        } else {
            System.out.println("The directory does not exist");
        }
    }
}