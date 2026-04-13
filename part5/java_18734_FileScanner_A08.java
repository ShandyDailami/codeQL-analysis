import java.io.File;
import java.util.Scanner;

public class java_18734_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File(".");
        FileScanner scanner = new FileScanner(file, "txt");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a file name:");
            String fileName = scan.nextLine();

            if (fileName.equalsIgnoreCase("quit")) {
                break;
            }

            file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File does not exist!");
                continue;
            }

            if (file.isDirectory()) {
                System.out.println("It is a directory!");
                continue;
            }

            if (!file.canRead()) {
                System.out.println("You do not have read permission!");
                continue;
            }

            System.out.println("Reading file: " + fileName);

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            }

            System.out.println("Finished reading file!");
        }

        scan.close();
    }
}