import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class AviaSoulsTest {


    @Test
    public void testSearch_SortsByPrice() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 9, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "SPb", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);


        Ticket[] expected = {t2, t1, t4};
        Ticket[] actual = manager.search("Moscow", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch_SortsByZero() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 9, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "SPb", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("Kazan", "SPb");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch_SortsByOne() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 9, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "Volgograd", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);


        Ticket[] expected = {t4};
        Ticket[] actual = manager.search("Moscow", "Volgograd");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 5, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "SPb", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {t1, t4, t2};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "SPb", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 9, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 5, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "Volgograd", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {t4};
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Volgograd", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 9, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 5, 11);
        Ticket t3 = new Ticket("Kazan", "Sochi", 500, 7, 9);
        Ticket t4 = new Ticket("Moscow", "SPb", 400, 7, 9);
        Ticket t5 = new Ticket("Kazan", "Sochi", 100, 7, 9);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Kazan", "SPb", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}









