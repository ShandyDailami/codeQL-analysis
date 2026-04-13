import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_15953_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        String dirPath = "/path/to/directory/";
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.trim().startsWith("A07_AuthFailure")) {
                            try {
                                MessageDigest md = MessageDigest.getInstance("MD5");
                                byte[] messageDigest = md.digest(line.getBytes());
                                StringBuilder hexString = new StringBuilder();
                                for (byte b : messageDigest) {
                                    hexString.append(String.format("%02X", b));
                                }
                                String authFailureCode = hexString.toString();

                                if (authFailureCode.equals("deadbeef")) {
                                    System.out.println("AuthFailure detected in file: " + file.getName());
                                }
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    br.close();
                }
            }
        }
    }
}