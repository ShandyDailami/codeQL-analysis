import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35712_FileScanner_A08 {
    private static int depth;

    public static void main(String[] args) {
        depth = 2; // Change the depth as needed

        File file = new File(".");
        scan(file, depth);
    }

    private static void scan(File file, int depth) {
        if (depth == 0) {
            return;
        }

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scan(f, depth - 1);
                } else if (f.getName().endsWith(".txt")) {
                    try {
                        Scanner scanner = new Scanner(f);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line); // Just for demonstration purposes, remove this line after scanning the file.
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}