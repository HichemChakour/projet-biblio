import org.example.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    Point p1;

    @Before
    public void setUp() {
        p1 = new Point(1, 2);
    }
    @Test
    public void testGetX() {
        assertEquals(1, p1.getX(),0.01);
    }
    @Test
    public void testGetY() {
        assertEquals(2, p1.getY(),0.01);
    }
}
