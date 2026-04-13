import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class java_27761_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 5000; // the port number to listen to

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            OutputStream output = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            // Receive client message
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send acknowledgement
            dos.writeUTF("Message received");

            socket.close();
        }
    }
}