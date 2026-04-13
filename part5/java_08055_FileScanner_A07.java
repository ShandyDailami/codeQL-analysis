import java.io.*;

public class java_08055_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file, "");
    }

    private static void printFiles(File file, String indent) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printFiles(f, indent + "  ");
                } else {
                    System.out.println(indent + f.getName());
                }
            }
        }
    }
}