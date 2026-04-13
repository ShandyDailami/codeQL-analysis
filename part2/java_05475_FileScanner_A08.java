import java.io.File;
import java.util.Scanner;

public class java_05475_FileScanner_A08 {
    public static void main(String[] args) {
        // Prompt the user for a directory
        System.out.print("Enter the directory: ");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.nextLine();
        scanner.close();

        // Create a File object representing the directory
        File file = new File(dir);

        // If the directory doesn't exist, print an error message and exit
        if (!file.exists()) {
            System.out.println("The directory does not exist!");
            return;
        }

        // Iterate over all files in the directory
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                // If the file is a text file, print its contents
                if (f.getName().endsWith(".txt")) {
                    try (Scanner scanner2 = new Scanner(f)) {
                        while (scanner2.hasNextLine()) {
                            System.out.println(scanner2.nextLine());
                        }
                    }
                }
            }
        }
    }
}