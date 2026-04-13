import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18317_SocketServer_A03 {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running = false;

    public java_18317_SocketServer_A03(int port) {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                handleClient();
            }
        } catch (Exception e) {
            // Handle exception
        }
    }

    private void handleClient() {
        running = true;
        String clientMessage;
        while (running && (clientMessage = readMessage()) != null) {
            if (clientMessage.equals("exit")) {
                out.println("Bye!");
                out.flush();
                closeClient();
                break;
            } else {
                out.println("Echo: " + clientMessage);
                out.flush();
            }
        }
    }

    private void closeClient() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            running = false;
        } catch (Exception e) {
            // Handle exception
        }
    }

    private String readMessage() {
        String message;
        try {
            message = in.readLine();
        } catch (Exception e) {
            message = null;
        }
        return message;
    }

    public static void main(String[] args) {
        new SocketServer(3333);
    }
}