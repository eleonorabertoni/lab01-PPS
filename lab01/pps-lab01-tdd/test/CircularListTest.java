import lab01.tdd.*;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    StrategyFactory strategyFactory = new StrategyFactoryImpl();

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testInitialSize() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void testSizeAfterAdd() {
        int numberOfElements = 5;
        for (int i = 0; i < numberOfElements; i++) {
            assertEquals(i, this.circularList.size());
            this.circularList.add(i);
        }

    }

    @Test
    public void testInitialListEmpty() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void testAddFirstElement() {
        assertTrue(circularList.isEmpty());
        circularList.add(0);
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void testNextOnEmptyList() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    public void testPreviousOnEmptyList() {
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    public void testNextOnSingleElementList() {
        this.circularList.add(1);
        List<Integer> expectedResult = List.of(1,1,1);
        List<Integer> testResult = this.repeatedCall(() -> circularList.next(), expectedResult.size());
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testPreviousOnSingleElementList() {
        this.circularList.add(1);
        List<Integer> expectedResult = List.of(1,1,1);
        List<Integer> testResult = this.repeatedCall(() -> circularList.previous(), expectedResult.size());
        assertEquals(expectedResult, testResult);

    }

    @Test
    public void testNext() {
        this.circularList = new CircularListImpl(List.of(1,2,3));
        List<Integer> expectedResult = List.of(1,2,3,1,2,3);
        List<Integer> testResult = this.repeatedCall(() -> circularList.next(), expectedResult.size());
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testPrevious() {
        this.circularList = new CircularListImpl(List.of(1,2,3));
        List<Integer> expectedResult = List.of(3,2,1,3,2,1);
        List<Integer> testResult = this.repeatedCall(() -> circularList.previous(), expectedResult.size());
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testNextAndPreviousAlternatively() {
        this.circularList = new CircularListImpl(List.of(1,2,3));
        List<Integer> expectedResult = List.of(1,1,1);
        List<Integer> testResult = this.repeatedCall(() -> circularList.next(),1);
        testResult.addAll(this.repeatedCall(() -> circularList.previous(), 1));
        testResult.addAll(this.repeatedCall(() -> circularList.next(), 1));
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testReset() {
        this.circularList = new CircularListImpl(List.of(1,2,3));
        List<Integer> expectedResult = List.of(1,2,1,2,3);
        List<Integer> testResult = this.repeatedCall(() -> circularList.next(), 2);
        circularList.reset();
        testResult.addAll(this.repeatedCall(() -> circularList.next(), 3));
        assertEquals(expectedResult, testResult);

    }

    @Test
    public void testNextWithEvenStrategySuccessful() {
        this.circularList = new CircularListImpl(List.of(1,2,3,4,5,6));
        List<Integer> expectedResult = List.of(2,4,6);
        ElementSelector es = () -> circularList.next(strategyFactory.createEvenStrategy());
        List<Integer> testResult = this.repeatedCall(es, 3);
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testNextWithEvenStrategyUnsuccessful() {
        this.circularList = new CircularListImpl(List.of(1,3,5));
        assertEquals(Optional.empty(), circularList.next(strategyFactory.createEvenStrategy()));
    }

    @Test
    public void testNextWithMultipleOfStrategySuccessful() {
        this.circularList = new CircularListImpl(List.of(1,2,3,4,5,6));
        List<Integer> expectedResult = List.of(2,4,6);
        ElementSelector es = () -> circularList.next(strategyFactory.createMultipleOfStrategy(2));
        List<Integer> testResult = this.repeatedCall(es, 3);
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testNextWithMultipleOfStrategyUnsuccessful() {
        this.circularList = new CircularListImpl(List.of(1,3,5));
        assertEquals(Optional.empty(), circularList.next(strategyFactory.createMultipleOfStrategy(2)));
    }

    @Test
    public void testNextWithEqualStrategySuccessful() {
        this.circularList = new CircularListImpl(List.of(1,2,3,4,5,6));
        List<Integer> expectedResult = List.of(4);
        ElementSelector es = () -> circularList.next(strategyFactory.createEqualsStrategy(4));
        List<Integer> testResult = this.repeatedCall(es, 1);
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testNextWithEqualStrategyUnsuccessful() {
        this.circularList = new CircularListImpl(List.of(1,3,5));
        assertEquals(Optional.empty(), circularList.next(strategyFactory.createMultipleOfStrategy(2)));
    }

    @Test
    public void testMixedCalls() {
        this.circularList = new CircularListImpl(List.of(1,2,3,4));
        List<Integer> expectedResult = List.of(2,4,2,2,1,4,4,1);
        ElementSelector es = () -> circularList.next(strategyFactory.createEvenStrategy());
        List<Integer> testResult = this.repeatedCall(es, 3);
        testResult.addAll(this.repeatedCall(() -> circularList.previous(), 3));
        testResult.addAll(this.repeatedCall(() -> circularList.next(), 2));
        assertEquals(expectedResult, testResult);
    }

    private List<Integer> repeatedCall(ElementSelector es, int numberOfCalls){
        List<Integer> testResult = new LinkedList<>();
        for (int i = 0; i < numberOfCalls; i++){
            Optional<Integer> element = es.getElement();
            assertTrue(element.isPresent());
            testResult.add(element.get());
        }
        return testResult;
    }
}

