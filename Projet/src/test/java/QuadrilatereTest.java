import org.example.Point;
import org.example.Quadrilatere;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadrilatereTest {
    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Quadrilatere quadrilatere;

    @Before
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 1);
        p3 = new Point(1, 1);
        p4 = new Point(1, 0);
        quadrilatere = new Quadrilatere(p1, p2, p3, p4);
    }

    @Test
    public void testGetPerimetre() {
        assertEquals(4.0, quadrilatere.getPerimetre(), 0.0001);
    }

    @Test
    public void testGetAire() {
        assertEquals(1.0, quadrilatere.getAire(), 0.0001);
    }


}
