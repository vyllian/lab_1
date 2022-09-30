package clothes.bottoms;

import clothes.Colour;

import java.util.Random;

public class RomanticBottoms extends Bottom {
    // constructor
    public RomanticBottoms(String colour){
        this.setStyle("Romantic");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());
        }
        this.setPoints_grow(16);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "pleated skirt" : "wideleg pants";
    }
}
