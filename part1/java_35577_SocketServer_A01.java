import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35577_SocketServer_A01 {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_35577_SocketServer_A01(Socket socket) {
        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void closeConnection() {
        try {
            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            SocketServer server = new SocketServer(socket);

            server.sendMessage("Hello, client!");
            String message = server.receiveMessage();

            System.out.println("Server says: " + message);

            server.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}