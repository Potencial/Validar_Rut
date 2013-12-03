package cl.cuadrasoft.validacion;

import cl.cuadrasoft.utilidades.Validar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ValidarTest {

    @Test
    public void testRut_String() {
        assertTrue("Rut Válido", Validar.rut("11.111.111-1"));
        assertTrue("Rut Válido", Validar.rut("11111111-1"));
        assertTrue("Rut Válido", Validar.rut("111111111"));

        assertFalse("Rut Inválido", Validar.rut("11.111.111-k"));
        assertFalse("Rut Inválido", Validar.rut("11111111-k"));
        assertFalse("Rut Inválido", Validar.rut("11111111k"));
    }

    @Test
    public void testRut_String_char() {
        assertTrue("Rut Válido", Validar.rut("11.111.111", '1'));
        assertTrue("Rut Válido", Validar.rut("11-111-111-", '1'));
        assertTrue("Rut Válido", Validar.rut("11111111", '1'));
        
        assertFalse("Rut Inválido", Validar.rut("11.111.111", ' '));
        assertFalse("Rut Inválido", Validar.rut("11111111-", 'k'));
        assertFalse("Rut Inválido", Validar.rut("11111111", '\u0000'));
    }

}
