import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_41102_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");

        // FileFilter
        File[] hiddenFiles = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        // FilenameFilter
        File[] hiddenFiles2 = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(".") && !name.endsWith(".java");
            }
        });

        // Using FileReader
        try (FileReader reader = new FileReader("Main.java")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Using Pattern and Matcher
        Pattern pattern = Pattern.compile("main");
        Matcher matcher = pattern.matcher("main");
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("Found main method");
        } else {
            System.out.println("Main method not found");
        }
    }
}