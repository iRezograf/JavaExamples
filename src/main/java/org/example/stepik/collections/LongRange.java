package org.example.stepik.collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class LongRange {

    public static void main(String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());

//        numbers.add(new LongRange(0, 5));
//        numbers.add(new LongRange(2, 4));
//        numbers.add(new LongRange(1, 4));
//        numbers.add(new LongRange(1, 7));
//        numbers.add(new LongRange(3, 5));
        numbers.add(new LongRange(0, 10));
        numbers.add(new LongRange(-10, 0));
        numbers.add(new LongRange(-4, 1));
        numbers.add(new LongRange(0, 5));
        numbers.forEach(System.out::println);
    }
    private final long left;
    private final long right;

    public  static Comparator<LongRange> getComparator() {
        // write your code here
        return Comparator
                .comparing(LongRange::getLength)
                .thenComparing(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    public long getLength() {
        return right-left;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}