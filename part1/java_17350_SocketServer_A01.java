import java.net.ServerSocket;
import java.net.Socket;

public class java_17350_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Here, you can handle the socket and perform security-sensitive operations
                // For instance, you can use socket streams for reading and writing data
                // For simplicity, we're just printing the received data

                java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream());
                java.io.DataOutputStream out = new java.io.DataOutputStream(socket.getOutputStream());

                String data = in.readUTF();
                System.out.println("Received: " + data);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}