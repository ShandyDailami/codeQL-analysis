import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_03334_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        int port = 5000;
        Socket socket = null;
        try {
            // create server socket
            socket = new Socket("localhost", port);

            // create input stream to receive data from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // create output stream to send data to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // read from client
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Received: " + response);
                out.println("Server response: Hello, client!");
            }
            socket.close();
        } finally {
            socket.close();
        }
    }
}