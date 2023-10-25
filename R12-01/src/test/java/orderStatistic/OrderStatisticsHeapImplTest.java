package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticsHeapImplTest {
    OrderStatisticsHeapImpl<Integer> pegadorDeEstatistica;

    @Before
    public void preenchendoTudo() {
        pegadorDeEstatistica = new OrderStatisticsHeapImpl<Integer>();
    }

    @Test
    public void testGetOrderStatistics() {
        Integer[] lista = new Integer[] { 1, 2, 3, 4, 5 };
        assertEquals(new Integer(3), pegadorDeEstatistica.getOrderStatistics(lista, 3));
    }
}
