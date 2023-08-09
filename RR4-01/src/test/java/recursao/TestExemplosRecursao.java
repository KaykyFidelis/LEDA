package recursao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExemplosRecursao {
    private ExemplosRecursao teste = new ExemplosRecursao();

    @Test
    public void teste1() {
        int[] array = { 0, 1, 1, 0 };
        assertEquals(teste.calcularZerosIterativo(array), 2);
    }
}
