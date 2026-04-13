import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_00735_SocketServer_A03 {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_00735_SocketServer_A03(Socket socket) {
        this.socket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public String receiveMessage() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            SocketServer server = new SocketServer(socket);

            server.sendMessage("Hello, client!");
            String message = server.receiveMessage();

            System.out.println("Server received: " + message);

            server.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}