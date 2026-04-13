import java.io.*;
import java.net.*;
import java.security.*;

public class java_17807_SocketServer_A08 {
    private static final String CORRECT_PASSWORD_MD5 = "21232f297a282b04ac4a80c262ec9499e"; 
    private static MessageDigest md; 

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client accepted");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientInput = dis.readUTF();
        System.out.println("Received: " + clientInput);

        // Verify password (not secure for real use, just for demonstration)
        if (!clientInput.equals(CORRECT_PASSWORD_MD5)) {
            dos.writeUTF("Failed");
            System.out.println("Authentication failed");
            return;
        }

        // If password is correct, serve files
        File file = new File("test.txt");
        dos.writeUTF("OK");

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int bytesNumRead = 0;
        while ((bytesNumRead = fis.read(buffer)) != -1) {
            dos.writeInt(bytesNumRead);
            dos.write(buffer, 0, bytesNumRead);
        }
        fis.close();
    }
}