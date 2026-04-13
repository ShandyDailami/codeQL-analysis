import java.io.File;
import java.util.Scanner;

public class java_35081_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String name = scanner.nextLine();

        File file = new File(name);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {
                    System.out.println("File exists and is a text file");
                } else {
                    System.out.println("File exists but is not a text file");
                }
            } else {
                System.out.println("File does not exist");
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}