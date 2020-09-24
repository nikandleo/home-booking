package personalfinance.saveload;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import personalfinance.model.Currency;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency {
    public static HashMap<String, Double> getRates(Currency base) throws Exception {
        HashMap<String, NodeList> result = new HashMap();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateFormat.format(new Date());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new URL(url).openStream());

        NodeList nl = doc.getElementsByTagName("Valute");
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node node = nl.item(i);
            NodeList nlChidls = node.getChildNodes();
            for (int j = 0; j < nlChidls.getLength(); j++){
                if(nlChidls.item(j).getNodeName().equals("CharCode"))
                    result.put(nlChidls.item(j).getTextContent(), nlChidls);
            }
        }
        HashMap<String, Double> rates = new HashMap();
        for (Map.Entry<String, NodeList> entry : result.entrySet())
        {
            NodeList tmp = entry.getValue();
            double value = 0;
            int nominal = 0;
            for (int i = 0; i < tmp.getLength(); i++)
            {
                if(tmp.item(i).getNodeName().equals("Value"))
                    value = Double.parseDouble(tmp.item(i).getTextContent().replace(',', '.'));
                else if(tmp.item(i).getNodeName().equals("Nominal"))
                    nominal = Integer.parseInt(tmp.item(i).getTextContent());
            }
            double amount = value / nominal;
            rates.put(entry.getKey(), (((double) Math.round(amount * 10000)) / 10000));
        }
        rates.put("RUB", 1.0);
        double div = rates.get(base.getCode());
        for (Map.Entry<String, Double> entry : rates.entrySet())
        {
            entry.setValue(entry.getValue() / div);
        }
        return rates;
    }
}
