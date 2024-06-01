package Data.Comparators;

import java.util.Comparator;

public class AppComparator<T> {
    public Comparator<T> comparator;
    public String name;

    public AppComparator(Comparator<T> comparator, String name) {
        this.comparator = comparator;
        this.name = name;
    }
}
