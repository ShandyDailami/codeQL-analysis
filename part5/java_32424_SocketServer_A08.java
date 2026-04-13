import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32424_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // listen on port 8080
            System.out.println("Waiting for connection on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept(); // accept a connection
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                // handle the client
                handleClient(socket);

                socket.close(); // close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream out = socket.getOutputStream();

            // read the client's message
            String message = in.readLine();
            System.out.println("Received: " + message);

            // return an integrity failure message
            out.write("Integrity failure\n".getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}