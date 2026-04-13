import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_15899_SocketServer_A01 {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_15899_SocketServer_A01(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void handleRequest() throws IOException {
        String message = reader.readLine();
        if (message != null) {
            handleMessage(message);
        }
    }

    private void handleMessage(String message) {
        if (message.equals("BAD_REQUEST")) {
            writer.println("Access Denied");
        } else {
            writer.println("Access Granted");
        }
        writer.flush();
    }

    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        SecureServer secureServer = new SecureServer(new Socket("localhost", 8080));
        secureServer.handleRequest();
        secureServer.close();
    }
}