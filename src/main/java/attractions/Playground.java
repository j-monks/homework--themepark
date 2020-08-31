package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        int visitorAge = visitor.getAge();
        if(visitorAge <= 15) {
            return true;
        } else {
            return false;
        }
    }
}
