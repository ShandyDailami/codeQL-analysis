import java.io.File;
import java.util.Arrays;

public class java_40236_FileScanner_A08 {

    public static void main(String[] args) {

        // create a File instance
        File file = new File(".");

        // list all files in the current directory
        File[] list = file.listFiles();

        if (list == null) {
            System.out.println("No files or directories in current directory");
            return;
        }

        // print all the file names
        Arrays.stream(list).map(File::getName).forEach(System.out::println);

    }

}