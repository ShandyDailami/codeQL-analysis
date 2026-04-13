import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_23485_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "<your directory path>";
        File directory = new File(directoryPath);
        
        if (directory.exists()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });
            
            if (files != null) {
                for (File file : files) {
                    try {
                        System.out.println("File name: " + file.getName());
                        
                        if (file.canRead()) {
                            System.out.println("File contents: ");
                            
                            byte[] byteBuffer = new byte[(int) file.length()];
                            FileInputStream fis = new FileInputStream(file);
                            
                            int bytesRead = fis.read(byteBuffer);
                            
                            while (bytesRead != -1) {
                                System.out.print(new String(byteBuffer, 0, bytesRead));
                                bytesRead = fis.read(byteBuffer);
                            }
                            
                            fis.close();
                        }
                        
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}