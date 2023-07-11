import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("City1", "City2", 2_000, 10, 11);
    Ticket ticket2 = new Ticket("City3", "City4", 1_000, 10, 19);
    Ticket ticket3 = new Ticket("City1", "City2", 3_000, 10, 15);
    Ticket ticket4 = new Ticket("City1", "City2", 3_000, 10, 14);

    AviaSouls manager = new AviaSouls();

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldReturnPositiveIfFirstPriceHigher() {
        System.out.println(ticket1.compareTo(ticket2));

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnNegativeIfFirstPriceLower() {
        System.out.println(ticket2.compareTo(ticket3));

        int expected = -1;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnZeroIfPricesEqual() {
        System.out.println(ticket3.compareTo(ticket4));

        int expected = 0;
        int actual = ticket3.compareTo(ticket4);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldRateFromLowToHighByPrice() {
        Ticket[] expected = {ticket1, ticket3, ticket4};
        Ticket[] actual = manager.search("City1", "City2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRateFromLowToHighByPriceByFlightTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket4, ticket3};
        Ticket[] actual = manager.searchAndSortBy("City1", "City2", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTicketOutOfList() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("City8", "City9");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchOneMatchingTicket() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("City3", "City4");

        Assertions.assertArrayEquals(expected, actual);
    }

}
