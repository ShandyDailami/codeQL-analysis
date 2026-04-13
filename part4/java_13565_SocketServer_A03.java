import java.io.*;
import java.net.*;

public class java_13565_SocketServer_A03 {

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Reading from client
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String clientInput = dataInputStream.readUTF();
                System.out.println("Client says: " + clientInput);

                // Sending a response
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}