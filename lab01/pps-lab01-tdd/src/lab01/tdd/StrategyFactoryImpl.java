package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory{

    @Override
    public SelectStrategy createEvenStrategy() {
        return element -> element % 2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int number) {
        return element -> element % number == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(int number) {
        return element -> element == number;
    }

}
