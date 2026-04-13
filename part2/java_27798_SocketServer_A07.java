import java.net.*;
import java.io.*;

public class java_27798_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 54321;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create streams for reading and writing
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Read the client's message
                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                dataOutputStream.writeUTF("Server received your message: " + message);
                dataOutputStream.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}