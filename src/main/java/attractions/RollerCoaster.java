package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        int visitorAge = visitor.getAge();
        double visitorHeight = visitor.getHeight();
        if(visitorHeight > 1.45 && visitorAge > 12) {
            return true;
        } else {
            return false;
        }
    }

    public double defaultPrice() {
        return 8.40;
    }

    public double priceFor(Visitor visitor) {
        double visitorHeight = visitor.getHeight();
        if(visitorHeight > 2.0) {
            return (defaultPrice() * 2);
        } else {
            return defaultPrice();
        }
    }
}
