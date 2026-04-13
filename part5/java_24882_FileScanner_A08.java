import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class java_24882_FileScanner_A08 {
    public static void main(String[] args) {
        Queue<File> files = new LinkedList<>();
        files.add(new File("."));

        while (!files.isEmpty()) {
            File file = files.poll();

            if (file.isDirectory()) {
                File[] children = file.listFiles();

                if (children != null) {
                    for (File child : children) {
                        if (child.isDirectory()) {
                            files.add(child);
                        } else if (child.isFile()) {
                            System.out.println(child.getPath());
                        }
                    }
                }
            } else if (file.isFile()) {
                System.out.println(file.getPath());
            }
        }
    }
}