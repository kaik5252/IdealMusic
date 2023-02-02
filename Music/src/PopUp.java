

import javax.swing.JOptionPane;

public class PopUp {
   
    public void showNotefy(String notefy) {
        JOptionPane.showMessageDialog(null, notefy, "Informação:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showAlert(String alert) {
        JOptionPane.showMessageDialog(null, alert, "Alerta!", JOptionPane.WARNING_MESSAGE);
    }
    
    public void showAlert(String alert, String title) {
        JOptionPane.showMessageDialog(null, alert, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public void showWarning(Exception error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showWarning(String error) {
        JOptionPane.showMessageDialog(null, error, "Oooops!!!", JOptionPane.ERROR_MESSAGE);
    }
}