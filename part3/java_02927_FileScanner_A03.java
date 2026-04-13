import java.io.File;
import java.util.Scanner;

public class java_02927_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path:");
        String filePath = scanner.next();
        scanner.close();

        File file = new File(filePath);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("The provided path is a directory. Please enter a file path.");
            } else {
                if (file.canRead()) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                            // This is the part where we are doing security-sensitive operations
                            // Let's say we are parsing the line to find a certain injection point
                            if (line.contains("injection point")) {
                                // This is where the security issue arises.
                                // We are allowing user input to execute a command on the system.
                                // This could be a command to execute a backdoor, download a file, etc.
                                Runtime.getRuntime().exec(line);
                            }
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("The file path provided can't be read. Please enter a valid file path.");
                }
            }
        } else {
            System.out.println("The file path provided does not exist. Please enter a valid file path.");
        }
    }
}