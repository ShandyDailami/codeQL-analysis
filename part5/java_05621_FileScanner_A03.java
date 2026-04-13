import java.io.File;
import java.io.FilenameFilter;

public class java_05621_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDirectory = new File("/path/to/directory");
        String extension = ".ext"; // Specify the file extension here

        File[] listOfFiles = rootDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if(listOfFiles != null) {
            for(File file : listOfFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}