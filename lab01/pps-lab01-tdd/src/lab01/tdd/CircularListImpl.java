package lab01.tdd;

import java.util.*;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private ListIterator<Integer> listIterator;

    public CircularListImpl() {

        this.list = new LinkedList<>();
    }

    public CircularListImpl(final List<Integer> list) {

        this.list = new LinkedList<>();
        for (int e: list) {
            this.add(e);
        }
    }

    @Override
    public void add(int element) {

        this.list.add(element);
        this.listIterator = this.list.listIterator();
    }

    @Override
    public int size() {

        return this.list.size();
    }

    @Override
    public boolean isEmpty() {

        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {

        return furtherElement(false, 0);
    }

    @Override
    public Optional<Integer> previous() {

        return furtherElement(true, this.size());

    }

    @Override
    public void reset() {

        this.listIterator = list.listIterator();
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {

        for(int i = 0; i < this.size(); i++){
            Optional<Integer> next = this.next();
            if(next.isPresent() && strategy.apply(next.get())){
                return Optional.of(list.get(this.listIterator.nextIndex()-1));
            }
        }
        return Optional.empty();
    }

    private Optional<Integer> furtherElement(final boolean prev, final int offset) {

        if (this.isEmpty()) {
            return Optional.empty();
        }

        if (prev? !this.listIterator.hasPrevious() : !this.listIterator.hasNext()) {
            this.listIterator = this.list.listIterator(offset);
        }
        return prev? Optional.of(this.listIterator.previous()) : Optional.of(this.listIterator.next());
    }

}
