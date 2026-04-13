import java.io.*;
import java.net.*;

public class java_38512_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started");

        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            writer.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            writer.flush();

            socket.close();
        }
    }
}