package Control;

import javax.swing.JOptionPane;

/**
 * 
 * @author Kaik D' Andrade
 */
public class PopUp {
   
    // PopUp de notificação
    public static void showNotefy(String notefy) {
        JOptionPane.showMessageDialog(null, notefy, "Informação:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // PopUp de alerta
    public static void showAlert(String alert) {
        JOptionPane.showMessageDialog(null, alert, "Alerta!", JOptionPane.WARNING_MESSAGE);
    }
    
    // PopUp de alerta porém com título como parâmetro
    public static void showAlert(String alert, String title) {
        JOptionPane.showMessageDialog(null, alert, title, JOptionPane.WARNING_MESSAGE);
    }
    
    // PopUp de erro com Exception, fecha o aplicativo
    public static void showWarning(Exception error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    
    // PopUp de erro com String, fecha o aplicativo
    public static void showWarning(String error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}