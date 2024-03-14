package String;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur  {


    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("Je suis le serveur j'attend une réponse");
        Socket socket= serverSocket.accept();


        InputStream is=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader bf=new BufferedReader(isr);
        String chaine= bf.readLine();

        System.out.println("Message recu : "+chaine);

        OutputStream os=socket.getOutputStream();
        PrintWriter pw= new PrintWriter(os,true);
        pw.println("Bien reçu");
    }

}
