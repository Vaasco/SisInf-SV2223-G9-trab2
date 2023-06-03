package businessLogic.View;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface View {
    void clear();

    Integer getInputInt() throws RuntimeException;

    Double getInputDouble() throws RuntimeException;

    BigDecimal getInputBigDecimal() throws RuntimeException;

    String getInputString();

    Integer getInputInt(String message) throws RuntimeException;

    String getInputString(String message);

    Double getInputDouble(String message) throws RuntimeException;

    BigDecimal getInputBigDecimal(String message) throws RuntimeException;

    void showMessage(String message);

    void displayError(String s);

    void waitForInput() throws IOException;

    void printList(List<?> list);
}