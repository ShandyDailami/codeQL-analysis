import java.io.File;
import java.io.FilenameFilter;
import java.security.Permission;
import java.security.Policy;

public class java_35024_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "/path/to/directory"; // Replace with your directory
        File file = new File(dir);

        file.setReadable(false, false);
        file.setWritable(false);

        file.deleteOnExit();

        new Thread(new Runnable() {
            public void run() {
                file.mkdirs();
                try {
                    Thread.sleep(1000);
                    file.delete();
                    Thread.sleep(1000);
                    file.createNewFile();
                    Thread.sleep(1000);
                    file.delete();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        file.renameTo(new File(file.getPath() + ".bak"));

        file.renameTo(file);

        file.setExecutable(true);

        file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(".");
            }
        });
    }
}