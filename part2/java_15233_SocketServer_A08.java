import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15233_SocketServer_A08 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(8189);
        System.out.println("Server started.");

        while (running) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted.");
            Writer writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("Connection successful.\n");
            writer.flush();
            clientSocket.close();
        }

        serverSocket.close();
        executor.shutdown();
    }
}