import java.io.*;

public class java_30501_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File dir = new File("."); // the directory to be scanned
            FileScanner fs = new FileScanner(dir);
            fs.scan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File dir;
    private boolean recursive;

    public java_30501_FileScanner_A03(File dir) {
        this.dir = dir;
        this.recursive = true;
    }

    public void scan() {
        File[] list = dir.listFiles();
        if (list == null) return;
        for (File file : list) {
            if (file.isDirectory()) {
                if (recursive) {
                    new FileScanner(file).scan();
                }
            } else {
                try {
                    process(file);
                } catch (Exception e) {
                    System.out.println("Error processing file: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }

    private void process(File file) throws IOException {
        // TODO: Implement security-sensitive operations related to A03_Injection
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            // TODO: Use the line here to perform operations related to A03_Injection
        }
        reader.close();
    }
}