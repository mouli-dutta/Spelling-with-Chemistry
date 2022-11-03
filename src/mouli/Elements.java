package mouli;

// wrapper class to hold Chemistry elements data
public class Elements {
    private final String atomicNumber;
    private final String symbol;
    private final String name;
    private final String block;
    private final String atomicWeight;
    private final String phase;
    private final String electronConfiguration;
    private final String color;

    public Elements(String atomicNumber, String symbol, String name, String block, String atomicWeight, String phase, String electronConfiguration, String color) {

        this.symbol = symbol;
        this.name = name;
        this.block = block;
        this.phase = phase;
        this.color = color;
        this.electronConfiguration = electronConfiguration;
        this.atomicWeight = atomicWeight;
        this.atomicNumber = atomicNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return
                "\nSymbol = " + symbol
                + "\nName = " + name
                + "\nAtomic Number = " + atomicNumber
                + "\nAtomic Weight = " + atomicWeight
                + "\nBlock = " + block
                + "\nPhase = " + phase
                + "\nColor = " + color
                + "\nElectron Configuration = " + electronConfiguration;
    }
}
