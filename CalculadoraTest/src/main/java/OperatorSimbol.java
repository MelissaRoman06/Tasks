import java.util.HashMap;
import java.util.Map;

public class OperatorSimbol {
    private Map<Operations, String> operators;
    public OperatorSimbol() {
        operators = new HashMap<Operations, String>() {{
            put(Operations.ADD, "+");
            put(Operations.SUBTRACT, "-");
            put(Operations.MULTIPLY, "×");
            put(Operations.DIVIDE, "÷");
        }};
    }

    public String getKeySimbol(Operations operation) {
        return operators.get(operation);
    }
}
