import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18035_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket server = (SSLServerSocket) serverSocket.accept();
            SSLSocket client = (SSLSocket) server.accept();
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(input);
            DataOutputStream dataOutputStream = new DataOutputStream(output);

            // Server receives a message from the client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client message: " + clientMessage);

            // Server sends a message back to the client
            String serverMessage = "Server says hello!";
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();

            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}