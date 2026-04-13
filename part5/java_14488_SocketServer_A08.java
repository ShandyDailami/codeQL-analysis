import java.net.ServerSocket;
import java.net.Socket;

public class java_14488_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // create a server socket and listen on port 1234
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for client...");

            // accept a client connection
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // get the input and output streams
            String response = "Hello, Client!";
            byte[] bytes = response.getBytes();

            // write bytes to the client
            socket.getOutputStream().write(bytes);

            // close the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}