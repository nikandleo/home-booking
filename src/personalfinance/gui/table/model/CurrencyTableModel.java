package personalfinance.gui.table.model;

import personalfinance.model.Currency;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

public class CurrencyTableModel extends MainTableModel {
    private static final int TITLE = 0;
    private static final int CODE = 1;
    private static final int RATE = 2;
    private static final int IS_ON = 3;
    private static final int IS_BASE = 4;

    public CurrencyTableModel(String[] columns){
        super(SaveData.getInstance().getCurrencies(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getCurrencies();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data.isEmpty()) return null;
        Currency currency = (Currency) data.get(rowIndex);
        switch (columnIndex){
            case TITLE:
                return currency.getTitle();
            case CODE:
                return currency.getCode();
            case RATE:
                return Format.rate(currency.getRate(), SaveData.getInstance().getBaseCurrency());
            case IS_ON:
                return Format.yesNo(currency.isOn());
            case IS_BASE:
                return Format.yesNo(currency.isBase());
        }
        return null;
    }
}
