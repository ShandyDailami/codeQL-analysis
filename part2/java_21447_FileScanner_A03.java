import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_21447_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(f -> {
                if (f.isFile()) {
                    System.out.println("File: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName());
                }
            });
        }
    }
}