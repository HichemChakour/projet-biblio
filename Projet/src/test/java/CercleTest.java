import org.example.Cercle;
import org.example.Point;
import org.junit.Before;
import org.junit.Test;

import static org.example.Cercle.pi;
import static org.junit.Assert.assertEquals;

public class CercleTest {
    Point p1;
    Point p2;
    Cercle c;

    @Before
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 2);
        c = new Cercle(p1, p2);
    }

    @Test
    public void testGetRayon() {
        assertEquals(2.0, c.getRayon(), 0.0001);
    }

    @Test
    public void testGetPerimetre() {
        assertEquals(2*pi*2, c.getPerimetre(), 0.0001);
    }

    @Test
    public void testGetPerimetreArrondi() {
        assertEquals(12.5, c.getPerimetre(2), 0.0001);
    }
    @Test
    public void testGetAire() {
        assertEquals(4*pi, c.getAire(), 0.0001);
    }
    @Test
    public void testGetAirArrondi() {
        assertEquals(12.5, c.getAire(2), 0.0001);
    }
}
