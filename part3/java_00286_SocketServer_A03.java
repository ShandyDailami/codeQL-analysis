import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_00286_SocketServer_A03 {
    public static void main(String[] args) {
        // Create a new thread for each connection
        new ServerThread(8080).start();
    }
}

class ServerThread extends Thread {
    private int port;

    public java_00286_SocketServer_A03(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // Create a new socket and bind it to a port
            Socket socket = new Socket("localhost", port);

            // Create a buffered reader to read data from the socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a print writer to write data to the socket
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Write a message to the socket
            writer.println("Hello, client!");

            // Read a line of data from the socket
            String response = reader.readLine();

            // Print the response to the console
            System.out.println("Server: " + response);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}