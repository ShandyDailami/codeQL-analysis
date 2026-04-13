import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_27401_SocketServer_A03 {

    private ExecutorService executor;
    private ServerSocket serverSocket;
    private boolean stopped;

    public java_27401_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        stopped = false;
        while (!stopped) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Exception caught when trying to accept a connection");
            }
        }
        executor.shutdown();
    }

    public void stop() throws IOException {
        stopped = true;
        serverSocket.close();
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_27401_SocketServer_A03(Socket socket) {
            clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can add the code for injection, as per A03_Injection.
                    // Example:
                    // response = doSomething(message);
                    out.println(response);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Exception caught when trying to read the response from the client");
            }
            closeConnection();
        }

        private void closeConnection() {
            try {
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            SecureSocketServer server = new SecureSocketServer(5000);
            server.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}