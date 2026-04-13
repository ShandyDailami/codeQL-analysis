import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_27940_FileScanner_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }
}

class FileScanner {
    private String directoryPath;

    public java_27940_FileScanner_A03() {
        directoryPath = "C:\\Users\\Username\\Desktop"; // change this to your directory
    }

    public void start() throws NoSuchAlgorithmException {
        File file = new File(directoryPath);
        if (file.exists()) {
            for (File f : file.listFiles()) {
                if (f.isFile()) {
                    printFileContents(f);
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void printFileContents(File file) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);
        byte[] dataBytes = new byte[1024];
        int nread;

        md.update(file.getName().getBytes());
        byte[] digest = md.digest();

        System.out.println("File: " + file.getName());
        System.out.println("SHA-256: " + convertByteArrayToHexaDecimal(digest));

        while ((nread = fis.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
            System.out.println("Data read: " + nread);
        }
        fis.close();
    }

    private String convertByteArrayToHexaDecimal(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}