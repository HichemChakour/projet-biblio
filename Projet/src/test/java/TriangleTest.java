import org.example.Point;
import org.example.Triangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    Point p1;
    Point p2;
    Point p3;
    Triangle triangle;

    @Before
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 1);
        p3 = new Point(1, 0);
        triangle = new Triangle(p1, p2, p3);
    }

    @Test
    public void testGetPerimetre() {
        assertEquals(3.4142, triangle.getPerimetre(), 0.0001);
    }

    @Test
    public void testGetAire() {
        assertEquals(0.5, triangle.getAire(), 0.0001);
    }

}
