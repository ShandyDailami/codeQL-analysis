import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_21341_FileScanner_A07 {

    public static void main(String[] args) {

        File file = new File(".");

        // Create a FileScanner
        Arrays.stream(file.listFiles()).forEach(Main::printFileSize);
    }

    private static void printFileSize(File file) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getAbsolutePath());
            Arrays.stream(file.listFiles()).forEach(Main::printFileSize);
        } else {
            System.out.println("File: " + file.getAbsolutePath() + " - " + formatFileSize(file.length()));
        }
    }

    private static String formatFileSize(long size) {
        if (size < 1024) {
            return size + " bytes";
        } else if (size < 1024 * 1024) {
            return size / 1024 + " Kb";
        } else if (size < 1024 * 1024 * 1024) {
            return size / (1024 * 1024) + " Mb";
        } else {
            return size / (1024 * 1024 * 1024) + " Gb";
        }
    }
}