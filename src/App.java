import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //CREATE FRAMES
        JFrame frame= new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(new BorderLayout());

        //CREATE MENU
        JMenuBar menuBar= new JMenuBar();
        JMenu fileMenu= new JMenu("Archivo");
        JMenu helpMenu= new JMenu("Ayuda");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        JMenuItem opeItem= new JMenuItem("Abrir");
        JMenuItem saveItem= new JMenuItem("Guardar Como");
        fileMenu.add(opeItem);
        fileMenu.add(saveItem);

        //CREAE PANEL
        JPanel panel= new JPanel(); //panel isnt viible yet
        JLabel messageJLabel = new JLabel("Mensaje: ");
        JTextField chatTextField =new JTextField(10); //acepta hasta 10 caracteres
        JButton sendButton= new JButton("Enviar");
        JButton resetButton= new JButton("Restablecer");
        panel.setLayout(new FlowLayout());
        panel.add(messageJLabel); //Componentes agregados usando
        panel.add(chatTextField);
        panel.add(sendButton);
        panel.add(resetButton);

        //Area de texto en el centro
        JTextArea chatHistory = new JTextArea();
        chatHistory.setEditable(false); //hace que la zona de chat no se pueda escribir

        //agregar componentes al marco
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, chatHistory);
        frame.setVisible(true);

        sendButton.addActionListener(e -> addMessage(chatTextField.getText(), chatHistory, chatTextField)); //e=ActionEvent, variable
        resetButton.addActionListener(e -> resetTextField(chatTextField));
        

    }

    public static void resetTextField(JTextField target){
        target.setText("");//aqui dice que al presionar el boton con las comillas aqui daria nulo, lo que borrara el texto
        
    }

    public static void addMessage(String messaje, JTextArea targTextArea, JTextField targerTextField) {
        targTextArea.append("\nRodrigo dice: " + messaje);
        resetTextField(targerTextField);
        
    }

}
