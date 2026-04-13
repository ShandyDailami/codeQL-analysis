import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15806_FileScanner_A07 {

    private static final String DIRECTORY = "C:\\Users\\Public\\"; // You should replace this with your directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(DIRECTORY + directory, fileName);
        if (file.exists() && !file.isDirectory()) {
            System.out.println("File exists: " + file.getName());
            try {
                File[] files = file.listFiles();
                Arrays.sort(files);
                for (File f : files) {
                    if (!f.canRead()) {
                        System.out.println("Access denied for: " + f.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist or it's not a directory.");
        }

        scanner.close();
    }
}