package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorOver13And146cmIsAllowed() {
        Visitor visitor = new Visitor(14, 146, 10);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorUnder146cmIsNotAllowed() {
        Visitor visitor = new Visitor(13, 1.45, 10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorUnder13IsNotAllowed() {
        Visitor visitor = new Visitor(12, 146, 10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.5);
    }

    @Test
    public void chargesStandardPriceUpTo2m() {
        Visitor visitor = new Visitor(26, 2.0, 10);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.5);
    }

    @Test
    public void chargesDoubleOver2m() {
        Visitor visitor = new Visitor(26, 2.1, 10);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.05);
    }
}
