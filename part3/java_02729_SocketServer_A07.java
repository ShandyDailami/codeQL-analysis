import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_02729_SocketServer_A07 {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_02729_SocketServer_A07(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public String receiveMessage() throws IOException {
        return reader.readLine();
    }

    public void closeConnection() throws IOException {
        writer.close();
        reader.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            // Create a new socket and bind it to port 1234
            Socket socket = new Socket("localhost", 1234);
            // Create a new server
            SocketServer server = new SocketServer(socket);

            // Send a message to the client
            server.sendMessage("Hello, client!");

            // Receive the response from the client
            String message = server.receiveMessage();
            System.out.println("Server received: " + message);

            // Close the connection
            server.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}