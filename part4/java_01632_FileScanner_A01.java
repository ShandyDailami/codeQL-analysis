import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class java_01632_FileScanner_A01 {
    public static void main(String[] args) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File("."));

        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            queue.offer(f);
                        } else {
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}