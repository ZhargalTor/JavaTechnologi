import java.util.Comparator;

public class FlatWareComparator
        implements Comparator<FlatWare> {

    @Override
    public int compare(FlatWare o1,
                       FlatWare o2) {

        return Integer.compare(
                o1.visual.length,
                o2.visual.length
        );
    }
}