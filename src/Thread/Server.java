package Thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("Je suis le serveur, j'attends une réponse");

        while (true) {
            try {
                // Attente d'une connexion entrante et acceptation de la connexion
                Socket socket = serverSocket.accept();

                // Création d'un thread pour gérer la connexion client
                Thread clientThread = new Thread(() -> {
                    try {
                        // Flux d'entrée depuis le client
                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader bf = new BufferedReader(isr);
                        String chaine = bf.readLine();

                        // Affichage du message reçu du client
                        System.out.println("Message reçu : " + chaine);

                        // Flux de sortie vers le client
                        OutputStream os = socket.getOutputStream();
                        PrintWriter pw = new PrintWriter(os, true);
                        pw.println("Bien reçu");

                        // Fermeture du socket
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                // Démarrage du thread
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(6666);
            server.start(); // Démarrage du serveur
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
