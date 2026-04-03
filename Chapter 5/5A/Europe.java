import java.util.ArrayList;
import java.util.List;

public class Europe {
    private String name;
    private List<TerritorialChange> history;

    public Europe(String name) {
        this.name = name;
        this.history = new ArrayList<>();
    }

    public void addChange(String country, int year, String event) {
        TerritorialChange change = new TerritorialChange(country, year, event);
        history.add(change);
    }

    public void showHistory() {
        System.out.println("\n История изменения территориального деления " + name );
        if (history.isEmpty()) {
            System.out.println("История пуста");
            return;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    public class TerritorialChange {
        private String country;
        private int year;
        private String event;

        public TerritorialChange(String country, int year, String event) {
            this.country = country;
            this.year = year;
            this.event = event;
        }

        public String getCountry() {
            return country;
        }

        public int getYear() {
            return year;
        }

        public String getEvent() {
            return event;
        }

        @Override
        public String toString() {
            return year + " год - " + country + ": " + event;
        }
    }
}