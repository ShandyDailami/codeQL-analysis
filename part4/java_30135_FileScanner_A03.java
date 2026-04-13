import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_30135_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] files = dir.list();

        if (files != null) {
            Set<String> set = new HashSet<>();
            for (String file : files) {
                // remove . and ..
                if (".".equals(file) || "..".equals(file)) {
                    continue;
                }

                // if file is not a directory
                File f = new File(file);
                if (f.isFile()) {
                    // if file is a text file and its size is less than 10000000
                    if (f.length() < 10000000) {
                        // add it to the set
                        set.add(f.getName());
                    }
                } else if (f.isDirectory()) {
                    // if file is a directory, add it to the set
                    set.add(f.getName());
                }
            }

            for (String name : set) {
                System.out.println(name);
            }
        }
    }
}