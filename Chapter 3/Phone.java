public class Phone {
    // Поля класса
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallTime;
    private double longDistanceCallTime;

    public Phone(int id, String lastName, String firstName, String patronymic,
                 String address, String creditCardNumber, double debit,
                 double credit, double localCallTime, double longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallTime = localCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public Phone(int id, String lastName, String firstName, String patronymic,
                 String address, double localCallTime, double longDistanceCallTime) {
        this(id, lastName, firstName, patronymic, address, "N/A", 0.0, 0.0,
                localCallTime, longDistanceCallTime);
    }

    public Phone(int id, String lastName, String firstName, String patronymic,
                 double localCallTime, double longDistanceCallTime) {
        this(id, lastName, firstName, patronymic, "Адрес не указан", "N/A",
                0.0, 0.0, localCallTime, longDistanceCallTime);
    }

    public Phone() {
        this(0, "Неизвестно", "Неизвестно", "Неизвестно",
                "Адрес не указан", "N/A", 0.0, 0.0, 0.0, 0.0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setLocalCallTime(double localCallTime) {
        this.localCallTime = localCallTime;
    }

    public void setLongDistanceCallTime(double longDistanceCallTime) {
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public double getDebit() {
        return debit;
    }

    public double getCredit() {
        return credit;
    }

    public double getLocalCallTime() {
        return localCallTime;
    }

    public double getLongDistanceCallTime() {
        return longDistanceCallTime;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s %s %s | Адрес: %s | Карта: %s | " +
                        "Дебет: %.2f | Кредит: %.2f | Городские: %.2f мин | " +
                        "Междугородные: %.2f мин",
                id, lastName, firstName, patronymic, address, creditCardNumber,
                debit, credit, localCallTime, longDistanceCallTime);
    }

    public String toShortString() {
        return String.format("%s %s %s | Городские: %.2f мин | Междугородные: %.2f мин",
                lastName, firstName, patronymic, localCallTime, longDistanceCallTime);
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public boolean hasLongDistanceCalls() {
        return longDistanceCallTime > 0;
    }
}