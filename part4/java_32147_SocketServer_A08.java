import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32147_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // port number
            Socket socket = server.accept(); // accept a client

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF(); // read a message from the client
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!"; // a sample response
            dos.writeUTF(serverMessage); // send a message to the client

            socket.close(); // close the connection

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}