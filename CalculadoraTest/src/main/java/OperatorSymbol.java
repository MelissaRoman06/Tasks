import java.util.HashMap;
import java.util.Map;

public class OperatorSymbol {
    private Map<Operations, String> operators;
    public OperatorSymbol() {
        operators = new HashMap<Operations, String>() {{
            put(Operations.ADD, "+");
            put(Operations.SUBTRACT, "-");
            put(Operations.MULTIPLY, "×");
            put(Operations.DIVIDE, "÷");
        }};
    }

    public String getKeySymbol(Operations operation) {
        return operators.get(operation);
    }
}
