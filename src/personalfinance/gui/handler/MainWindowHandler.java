package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.saveload.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we){
        if(SaveData.getInstance().isSaved())
            System.exit(0);
        else{
            int result = ConfirmDialog.show((MainFrame) we.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if(result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
}
