import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.Paths;
import java.util.Iterator;

public class java_42017_FileScanner_A07 {
    public static void main(String[] args) {
        FileSystems fs = FileSystems.getDefault();
        Path path = Paths.get(".");
        Iterator<Path> it = fs.newDirectoryStream(path).iterator();

        while(it.hasNext()){
            Path p = it.next();
            System.out.println(p.toString());
        }
    }
}