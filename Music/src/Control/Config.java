package Control;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Kaik D' Andrade
 */
public class Config {
    /**
     * Método responsável por retornar o caminho absoluto do projeto, até a
     * pasta `resources`
     *
     * @param folder
     * @return String
     * @author Kaik D' Andrade
     */
    public static String retPath(String folder) {
        return System.getProperty("user.dir") + "\\src\\resources/" + folder;
    }

    /**
     * Método responsável por limpar os campos de texto
     *
     * @author Kaik D' Andrade
     * @param fields
     */
    public static void clearTextFields(javax.swing.JTextField... fields) {
        for (javax.swing.JTextField field : fields) {
            if (!field.getText().equals("")) {
                field.setText("");
            }
        }
    }

    /**
     * Método resposável por abrir um card de um deteminado painel
     *
     * @author Kaik D' Andrade
     * @param panel
     * @param cardName
     */
    public static void openCard(javax.swing.JPanel panel, String cardName) {
        java.awt.CardLayout card = (java.awt.CardLayout) panel.getLayout();
        card.show(panel, cardName);
    }

    /**
     * @author Kaik d' Andrade
     * @param frame
     * @param title
     * @param panel
     * @param card
     */
    public static void openFrame(JFrame frame, String title, javax.swing.JPanel panel, String card) {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));
        openCard(panel, card);
    }

    /**
     *
     * @param closeFrame
     * @param openFrame
     */
    public static void closeFrame(JFrame closeFrame, JFrame openFrame) {
        closeFrame.setVisible(false);
        openFrame.setVisible(true);
        openFrame.setLocationRelativeTo(null);
    }

    /**
     * Método responsável por abrir um JFileChooser
     *
     * @param title
     * @param description
     * @param types
     * @return
     * @author Kaik D' Andrade
     */
    public static String fileChooser(String title, String description, String... types) {
        // Cria um frame para comportar o JFileChooser
        JFrame frameChooser = new JFrame();
        frameChooser.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));

        // Cria o JFileChooser e coloca um título
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(title);

        // Desativa a opção de `AllFiles`
        fc.setAcceptAllFileFilterUsed(false);

        // Faz com que o JFileChooser abra no diretório referente ao desktop
        fc.setCurrentDirectory(new File(System.getProperty("user.home") + "/desktop"));

        // Descrição do JFileChooser
        description = description + " (*." + String.join(";*.", types) + ")";
        FileNameExtensionFilter filter = new FileNameExtensionFilter(description, types);

        // Deixa oculto os arquivos e diretórios ocultos 
        fc.setFileHidingEnabled(true);

        // Desativa seleção multipla
        fc.setMultiSelectionEnabled(false);

        // Põe um filtro no JFileChooser
        fc.setFileFilter(filter);

        // Manda o JFileChooser enxergar
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Verifica se algum arquivo foi selecionado
        int ret = fc.showOpenDialog(frameChooser);
        if (ret == JFileChooser.APPROVE_OPTION) {
            // Retorna o caminho do arquivo selecionado
            return fc.getSelectedFile().getPath();
        }

        // Caso não tenha selecionado um arquivo, retorna nulo
        return null;
    }
}
