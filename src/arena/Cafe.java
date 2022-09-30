package arena;

public class Cafe extends Arena {
    // constructor
    public Cafe (){
        this.setName("Cafe");
        this.setPreferable_style("Basic");
    }
    // override
    public double coeff(String style) {
        return style.equals("Basic") ? 1.0 : 0;
    }
}
