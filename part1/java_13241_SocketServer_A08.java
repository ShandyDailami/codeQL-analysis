import java.io.*;
import java.net.*;

public class java_13241_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Listens on port 8080

        while (true) {
            Socket socket = serverSocket.accept();
            new SocketHandler(socket).start();
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_13241_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            if ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here you can add your security-sensitive operations related to A08_IntegrityFailure
                // For example, you can check the integrity of the received data, verify the client's identity,
                // or perform other checks.

                out.println("Hello, client, message received.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}