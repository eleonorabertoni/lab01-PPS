package lab01.tdd;

public interface StrategyFactory {

    /**
     *
     * @return a strategy to get the next even element.
     */
    SelectStrategy createEvenStrategy();

    /**
     * @param number
     * @return a strategy to get the next multiple of a given number
     */
    SelectStrategy createMultipleOfStrategy(int number);

    /**
     * @param number
     * @return a strategy to get the next equal element of a given number
     */
    SelectStrategy createEqualsStrategy(int number);

}
