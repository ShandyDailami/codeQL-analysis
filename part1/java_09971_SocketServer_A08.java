import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09971_SocketServer_A08 {
    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            executor.execute(new SocketHandler(clientSocket));
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_09971_SocketServer_A08(Socket socket) {
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
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    socket.close();
                    System.out.println("Client disconnected");
                    return;
                }

                // Here is the place for security sensitive operation related to A08_IntegrityFailure
                // For simplicity, we just send back the same message to the client
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}