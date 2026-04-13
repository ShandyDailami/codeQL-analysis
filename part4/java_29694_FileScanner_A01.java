import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29694_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("File name: " + file.getName());

                        // This is a security-sensitive operation related to A01_BrokenAccessControl
                        try {
                            FileReader fr = new FileReader(file);
                            int ch;
                            while ((ch = fr.read()) != -1) {
                                System.out.print((char) ch);
                            }
                            fr.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        System.out.println();
                    }
                });
            }
        } else {
            System.out.println("The path does not exist or is not a directory.");
        }
    }
}