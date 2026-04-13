import java.io.*;
import java.net.*;

public class java_32174_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handling incoming connection
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Receive client's message
                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);

                // Echo back the message to client
                String response = "Server received your message: " + message;
                dataOutputStream.writeUTF(response);
                dataOutputStream.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}