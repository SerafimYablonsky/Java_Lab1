package mainPackage;

public class ChewingGum extends Food {
    private String flavour;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public ChewingGum(String flavour) {
        super("Жевательная резинка");
        this.flavour = flavour;
    }

    public String toString() {
        return super.toString() + " со вкусом '" + this.flavour.toUpperCase() + "'";
    }

    public void consume() {
        System.out.println(this + " прожёвана");
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof ChewingGum)) return false;
            return flavour.equals(((ChewingGum)arg0).flavour);
        } else
            return false;
    }

    public int calculateCalories() {
        int calories = 0;
        switch (this.flavour) {
            case "мята": {
                calories += 25;
                break;
            }
            case "арбуз": {
                calories += 20;
                break;
            }
            case "вишня": {
                calories += 15;
                break;
            }
        }
        return calories;
    }
}
