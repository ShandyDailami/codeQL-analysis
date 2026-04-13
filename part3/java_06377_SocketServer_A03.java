import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06377_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Here, we're creating a new thread for each connection,
                // but this can be done in a more sophisticated way,
                // such as using ExecutorService or an Async task.
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("IOException was caught: " + e.getMessage());
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public java_06377_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, we're just accepting and echoing data from the socket,
        // but this can be done in a more sophisticated way,
        // such as using a BufferedReader and PrintWriter.
        try (Socket clientSocket = socket;
             java.io.BufferedReader in = new java.io.BufferedReader(
                     new java.io.InputStreamReader(socket.getInputStream()));
             java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Here, we're just echoing back the data,
                // but this can be done in a more sophisticated way,
                // such as using a secure and trusted protocol.
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.err.println("IOException was caught: " + e.getMessage());
        }
    }
}