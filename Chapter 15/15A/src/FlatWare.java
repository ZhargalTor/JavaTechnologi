public class FlatWare {

    String type;
    String origin;
    Visual visual;
    boolean value;

    @Override
    public String toString() {

        return type + " | " +
                origin + " | " +
                visual.length;
    }
}