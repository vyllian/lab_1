package arena;

public abstract class Arena {

    private String name;
    private String preferable_style;
    // constuctor
    public Arena(){};
    // setters and getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPreferable_style() {
        return preferable_style;
    }
    public void setPreferable_style(String preferable_style) {
        this.preferable_style = preferable_style;
    }

    /**
     * Defines a conformity of arena and style
     * @param style name of style
     * @return coefficient
     */
    public abstract double coeff(String style);
    @Override
    public String toString() {
        return "-----------------"+ name +"-----------------\n";
    }
}
