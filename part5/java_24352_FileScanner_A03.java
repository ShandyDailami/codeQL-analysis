import java.io.*;

public class java_24352_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");

        // Use recursiveFileList method to get all the files and directories in the current directory
        String[] files = recursiveFileList(file);

        // Print all the files and directories
        for (String str : files) {
            System.out.println(str);
        }
    }

    // recursiveFileList method to get all the files and directories in the current directory
    private static String[] recursiveFileList(File file) {
        File[] files = file.listFiles();

        if (files == null) return new String[0];

        String[] result = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            result[i] = files[i].getPath();
        }

        // Recursively call the method for all directories
        for (int i = 0; i < result.length; i++) {
            result[i] = recursiveFileList(new File(result[i]));
        }

        return result;
    }
}