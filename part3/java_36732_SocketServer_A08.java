import java.io.*;
import java.net.*;

public class java_36732_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189...");
        
        Socket client = server.accept();
        System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
        
        OutputStream out = new BufferedOutputStream(client.getOutputStream());
        DataOutputStream writer = new DataOutputStream(out);
        
        DataInputStream in = new DataInputStream(client.getInputStream());
        String data = in.readUTF(); // Read the message from the client
        
        // Encrypt the data
        String encryptedData = encryptData(data);
        
        // Send the encrypted data back to the client
        writer.writeUTF(encryptedData);
        writer.flush();
        
        client.close();
        server.close();
    }
    
    private static String encryptData(String data) {
        // This is a simple example of encrypting data, in a real world scenario you would use a stronger method
        StringBuilder encryptedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            encryptedData.append((char) (c ^ 123)); // XOR with 123
        }
        return encryptedData.toString();
    }
}