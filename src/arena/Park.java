package arena;

public class Park extends Arena {
    // constructor
    public Park (){
        this.setName("Park");
        this.setPreferable_style("Casual");

    }
    // override
    public double coeff(String style) {
        return switch (style) {
            case "Casual", "Basic" -> 1.0;
            case "Romantic" -> 0.5;
            default -> -0.5;
        };
    }

}
