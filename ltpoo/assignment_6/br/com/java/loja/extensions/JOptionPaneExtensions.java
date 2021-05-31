package br.com.java.loja.extensions;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class JOptionPaneExtensions {

    public static <T> T getJOptionInput(Class<T> type, String inputName) throws Exception {
        String outputStr = null;
        if (type != Date.class) {
            outputStr = JOptionPane.showInputDialog(inputName);
        }

        Object output;
        if (type == String.class) {
            output = outputStr;
        } else if (type == Integer.class) {
            output = Integer.parseInt(outputStr);
        } else if (type == Float.class) {
            output = Float.parseFloat(outputStr);
        } else if (type == Boolean.class) {
            output = Boolean.parseBoolean(outputStr);
        } else if (type == Date.class) {
            String dateResult = getJOptionInput(String.class, inputName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            output = dateFormat.parse(dateResult);
        } else {
            throw new Exception(String.format("Type (class: %s) not implement!", type.getClass().getName()));
        }

        return type.cast(output);
    }
}
