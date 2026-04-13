import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_40323_SocketServer_A08 {

    // Standard port for SocketServer
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected!");

            // Create buffered input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read data from client
            String data = in.readLine();
            System.out.println("Received data: " + data);

            // Data security here
            // Use symmetric encryption like AES or RSA for secure data transfer
            // Here, we'll use AES for simplicity
            Key key = KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = cipher.doFinal(data.getBytes());

            // Send encrypted data to client
            out.write(encryptedData);
            out.flush();
       
            client.close();
        }
    }
}