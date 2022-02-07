package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(14, 1.5, 40.0);
        visitor2 = new Visitor(21, 1.4, 32.50);
        visitor3 = new Visitor(11, 2.1, 12.75);
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
    public void visitorIsAllowedIfOldAndTallEnough() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void visitorNotAllowedIfNotTallEnough() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void visitorNotAllowedIfNotOldEnough() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void doubleChargeIfVisitorTooTall() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor3), 0.0);
    }

    @Test
    public void normalChargeIfVisitorNotTooTall() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.0);
    }
}
