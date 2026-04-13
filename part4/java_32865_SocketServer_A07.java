import java.io.*;
import java.net.*;

public class java_32865_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for a client...");

            // Accept a client
            socket = serverSocket.accept();
            System.out.println("Client accepted!");

            // Create a writer
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Create a reader
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Read from the socket
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server: " + inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}