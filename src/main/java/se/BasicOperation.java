package se;

public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public int apply(int left, int right) {
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int left, int right) {
            return left - right;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int left, int right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int left, int right) {
            return left / right;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
}
