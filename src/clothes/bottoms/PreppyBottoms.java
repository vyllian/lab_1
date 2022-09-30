package clothes.bottoms;

import clothes.Colour;

import java.util.Random;

public class PreppyBottoms extends Bottom {
    // constructor
    public PreppyBottoms(String colour){
        this.setStyle("Preppy");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());
        }
        this.setPoints_grow(16);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "bermuda shorts" : "tennis skirt";
    }
}
