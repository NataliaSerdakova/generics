import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {

    @Test
    public void testCompareTo_BasedOnPrice() {
        Ticket ticket1 = new Ticket("Moscow", "SPb", 100, 10, 12);
        Ticket ticket2 = new Ticket("Moscow", "SPb", 200, 11, 13);
        Ticket ticket3 = new Ticket("Moscow", "SPb", 100, 14, 16);

        Assertions.assertTrue(ticket1.compareTo(ticket2) < 0); //Ticket1 should be дешевле Ticket2
        Assertions.assertTrue(ticket2.compareTo(ticket1) > 0); //Ticket2 должна быть дороже Ticket1
        Assertions.assertEquals(0, ticket1.compareTo(ticket3)); //Ticket1 и Ticket3 должны иметь одинаковую цену
    }

    @Test
    public void testSearch_SortsByPrice() {
        AviaSouls avia = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 10);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 9, 11);
        Ticket t3 = new Ticket("Moscow", "SPb", 400, 7, 9);

        avia.add(t1);
        avia.add(t2);
        avia.add(t3);

        Ticket[] result = avia.search("Moscow", "SPb");

        Assertions.assertEquals(3, result.length);
        Assertions.assertEquals(t2, result[0]); //Первый билет должен быть дешевле
        Assertions.assertEquals(t1, result[1]); //Второй билет по цене
        Assertions.assertEquals(t3, result[2]); //Третий билет по цене
    }

    @Test
    public void testSearchAndSortBy_TimeComparator() {
        AviaSouls avia = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 300, 8, 11);
        Ticket t2 = new Ticket("Moscow", "SPb", 200, 9, 13);
        Ticket t3 = new Ticket("Moscow", "SPb", 400, 7, 9);

        avia.add(t1);
        avia.add(t2);
        avia.add(t3);

        TicketTimeComparator timeComp = new TicketTimeComparator();

        Ticket[] sortedByTime = avia.searchAndSortBy("Moscow", "SPb", timeComp);


        Assertions.assertEquals(3, sortedByTime.length);
        Assertions.assertEquals(t3, sortedByTime[0]); //Самый короткий
        Assertions.assertEquals(t1, sortedByTime[1]); //Следующий по времени
        Assertions.assertEquals(t2, sortedByTime[2]); //Самый длинный
    }

    @Test
    public void testAddAndFindAll() {
        AviaSouls avia = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "SPb", 100, 10, 12);

        avia.add(t1);

        Ticket[] allTickets = avia.findAll();

        Assertions.assertEquals(1, allTickets.length);
        Assertions.assertEquals(t1, allTickets[0]);
    }
}





