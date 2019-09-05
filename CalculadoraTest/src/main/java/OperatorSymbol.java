import java.util.HashMap;
import java.util.Map;

/**
 * This class has a hash map used to parse Operations enum to corresponding key symbol.
 */
public class OperatorSymbol {
    private Map<Operations, String> operators;

    /**
     * Sets hash map content.
     */
    public OperatorSymbol() {
        operators = new HashMap<Operations, String>() {{
            put(Operations.ADD, "+");
            put(Operations.SUBTRACT, "-");
            put(Operations.MULTIPLY, "×");
            put(Operations.DIVIDE, "÷");
        }};
    }

    /**
     * Allows to get key symbol of the requested operation.
     * @param operation - An option from Operations enum.
     * @return - Key symbol which corresponds to operation input.
     */
    public String getKeySymbol(Operations operation) {
        return operators.get(operation);
    }
}
