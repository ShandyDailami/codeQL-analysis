import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_32074_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("No files found in the directory!");
            System.exit(1);
        }

        List<File> sortedFiles = new ArrayList<>();
        long minSize = Long.MAX_VALUE;
        long maxSize = Long.MIN_VALUE;
        long sum = 0;
        int count = 0;

        for (File file : files) {
            if (file.isFile()) {
                long size = file.length();
                sum += size;
                count++;

                if (size < minSize) {
                    minSize = size;
                }

                if (size > maxSize) {
                    maxSize = size;
                }

                sortedFiles.add(file);
            }
        }

        if (count == 0) {
            System.out.println("No files found in the directory!");
            System.exit(1);
        }

        System.out.println("Minimum size: " + minSize);
        System.out.println("Maximum size: " + maxSize);
        System.out.println("Average size: " + (sum / count));

        for (File file : sortedFiles) {
            System.out.println(file.getName() + ": " + file.length() + " bytes");
        }
    }
}