import java.io.File;
import java.security.InvalidParameterException;

public class java_19916_FileScanner_A08 {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new InvalidParameterException("Usage: java Main <directory>");
        }
        File dir = new File(args[0]);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Directory does not exist");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Given argument is not a directory");
        }
        listFiles(dir, "");
    }

    private static void listFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listFiles(file, indent + "    ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }
}