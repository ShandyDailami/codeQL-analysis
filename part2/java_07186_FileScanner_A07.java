import java.io.File;
import java.io.FileFilter;
import java.util.stream.Stream;

public class java_07186_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDirectory = new File("path/to/directory");
        String ending = ".txt";

        File[] matchingFiles = rootDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(ending);
            }
        });

        if(matchingFiles != null){
            Stream.of(matchingFiles)
                  .map(File::getAbsolutePath)
                  .forEach(System.out::println);
        }
    }
}