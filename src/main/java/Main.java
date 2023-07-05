public class Main {

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(
                "City1",
                "City2",
                2_000,
                10,
                9
        );

        Ticket ticket2 = new Ticket(
                "City1",
                "City2",
                1_000,
                10,
                15
        );

        System.out.println(ticket1.compareTo(ticket2));
    }
}