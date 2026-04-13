import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32508_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000); // listen on port 8000
            System.out.println("Server is running and waiting for connections on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Here, we're assuming the client will send a message, and we'll just keep listening for that message
                // If the client doesn't send a certain message, we'll immediately close the connection
                while (true) {
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    if (message.equals("close")) {
                        System.out.println("Client requested closing connection");
                        socket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}