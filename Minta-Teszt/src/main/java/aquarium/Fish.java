package aquarium;

public abstract class Fish {
    protected int weight;
    protected boolean forgets;
    private final String name;
    private final String color;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return forgets;
    }

    public abstract void feed();

    public String getStatus() {
        return String.format("%s, weight: %d, color: %s, short-term memory loss: %s", name, weight, color, forgets);
    }
}