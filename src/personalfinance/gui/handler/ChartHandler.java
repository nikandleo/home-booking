package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.StatisticsPanel;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class ChartHandler extends Handler{
    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case HandlerCode.TYPE: {
                ((StatisticsPanel)frame.getRightPanel()).nextType();
            }
        }
        super.actionPerformed(e);
    }
}
