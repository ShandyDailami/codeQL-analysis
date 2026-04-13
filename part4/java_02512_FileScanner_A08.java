import java.io.File;

public class java_02512_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        
        if (directory.exists() && directory.isDirectory()) {
            String[] fileNames = directory.list();
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    File file = new File(directory, fileName);
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}