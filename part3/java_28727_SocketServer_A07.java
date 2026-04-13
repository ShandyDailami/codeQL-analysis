import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_28727_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    private final int port;

    public java_28727_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        new Thread(() -> {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try (ServerSocket serverSocket = (ServerSocket) sslSocketFactory.createServerSocket(port)) {
                logger.info("Starting server on port " + port);

                while (true) {
                    try (Socket clientSocket = serverSocket.accept()) {
                        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(clientSocket, port, true);

                        sslSocket.setNeedClientAuth(true);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

                        String request = reader.readLine();

                        if (request != null && request.equalsIgnoreCase("AUTHENTICATE")) {
                            writer.println("200 OK");
                            writer.flush();

                            // Continue authentication
                            while (true) {
                                request = reader.readLine();

                                if (request == null || !request.startsWith("AUTH ")) {
                                    logger.severe("Authentication failed!");
                                    break;
                                }

                                String[] parts = request.split(" ");

                                if (!parts[1].equals(parts[2])) {
                                    logger.severe("Authentication failed!");
                                    break;
                                }

                                logger.info("Authentication successful!");

                                // Send response
                                writer.println("200 OK");
                                writer.flush();

                                break;
                            }
                        } else {
                            logger.severe("Unknown request!");
                        }
                    }
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Exception occurred while running the server", ex);
            }
        }).start();
    }
}