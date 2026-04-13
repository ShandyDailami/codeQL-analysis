import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31457_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000); // Listening on port 5000
        while (true) {
            Socket socket = server.accept(); // Accept a client connection
            System.out.println("New client connected!");
            OutputStream output = socket.getOutputStream();
            output.write("Welcome to the Socket Server!\r\n".getBytes());
            output.flush();
            socket.close();
        }
    }
}