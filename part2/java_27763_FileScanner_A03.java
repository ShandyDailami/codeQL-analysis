import java.io.*;

public class java_27763_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File dir = new File(dirPath);

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File size: " + file.length() + " bytes");
                    System.out.println("-------------------------");
                }
            }
        } else {
            System.out.println("No files with extension " + fileExtension + " found in " + dirPath);
        }
    }
}