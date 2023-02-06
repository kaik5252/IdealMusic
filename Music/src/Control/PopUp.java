package Control;

import javax.swing.JOptionPane;

public class PopUp {
   
    public static void showNotefy(String notefy) {
        JOptionPane.showMessageDialog(null, notefy, "Informação:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showAlert(String alert) {
        JOptionPane.showMessageDialog(null, alert, "Alerta!", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showAlert(String alert, String title) {
        JOptionPane.showMessageDialog(null, alert, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showWarning(Exception error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    
    public static void showWarning(String error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}