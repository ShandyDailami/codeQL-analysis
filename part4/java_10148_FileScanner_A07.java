import java.io.File;
import java.util.Scanner;

public class java_10148_FileScanner_A07 {
    private static final String DIRECTORY = "src/main/resources";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();
        File file = new File(DIRECTORY, fileName);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File exists: " + file.getName());
                if (file.canRead()) {
                    System.out.println("File can be read: " + file.getAbsolutePath());
                } else {
                    System.out.println("File can't be read: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("Provided path is not a file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("File does not exist at: " + file.getAbsolutePath());
        }

        scanner.close();
    }
}