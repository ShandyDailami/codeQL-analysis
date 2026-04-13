import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_28280_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] txtFiles = dir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory");
            return;
        }

        Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getName()));
    }

}