import java.net.ServerSocket;
import java.net.Socket;

public class java_38312_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();
            // Here we are assuming that the client is trying to connect to the server and send a message.
            // However, there is no way to check if the client is trying to break into the server or access the server for another purpose.
            // This is a simplification and not intended for a real-world situation.
            socket.getInputStream().read();
        }
    }
}