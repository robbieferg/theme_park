import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themePark;

    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;

    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    Visitor visitor1;

    @Before
    public void before() {
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Wonderland", 3);
        playground = new Playground("Happy World", 4);
        rollerCoaster = new RollerCoaster("The Death Machine", 1);
        candyflossStall = new CandyflossStall("FlossLand", "Candy Floss Industries", ParkingSpot.A1, 2);
        iceCreamStall = new IceCreamStall("Mr. Icee", "John Smith", ParkingSpot.B1, 5);
        tobaccoStall = new TobaccoStall("Jimmy's Cigs", "FFred Jones", ParkingSpot.B3, 4);
        visitor1 = new Visitor(34, 1.3, 40.95);

        themePark = new ThemePark();
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);
    }

    @Test
    public void canAddAttractions() {
        assertEquals(4, themePark.getAttractions().size());
    }

    @Test
    public void canAddStalls() {
        assertEquals(3, themePark.getStalls().size());
    };

    @Test
    public void canRemoveAttraction() {
        themePark.removeAttraction(playground);
        assertEquals(3, themePark.getAttractions().size());
    }

    @Test
    public void canRemoveStall() {
        themePark.removeStall(iceCreamStall);
        assertEquals(2, themePark.getStalls().size());
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisit() {
            themePark.visit(visitor1, dodgems);
            assertEquals(1, dodgems.getVisitCount());
            assertEquals(1, visitor1.getVisitedAttractions().size());
        }

    }

