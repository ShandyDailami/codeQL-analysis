import java.io.File;
import java.util.regex.Pattern;

public class java_14940_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String pattern = "A*.txt";
        Pattern regex = Pattern.compile(pattern);

        File[] foundFiles = directory.listFiles((File pathname) ->
                pathname.isFile() && regex.matcher(pathname.getName()).matches()
        );

        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getName());
            }
        }
    }
}