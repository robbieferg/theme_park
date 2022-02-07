package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;


public class RollerCoaster extends Attraction implements ISecurity, ITicketed {
    private double startingPrice;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.startingPrice = 8.40;
    }

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() >= 12 && visitor.getHeight() >= 1.45) {
            return true;
        }
        return false;
    }

    public double defaultPrice() {
        return startingPrice;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 2.0) {
            return defaultPrice() * 2;
        }
        return defaultPrice();
    }
}
