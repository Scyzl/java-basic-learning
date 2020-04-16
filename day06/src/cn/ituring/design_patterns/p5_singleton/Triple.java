package cn.ituring.design_patterns.p5_singleton;

public class Triple {
    private static Triple[] triples = new Triple[] {
            new Triple(0),
            new Triple(1),
            new Triple(2),
    };

    private int id;

    private Triple(int id) {
        System.out.println("The instance " + id + " is created");
        this.id = id;
    }

    public static Triple getInstance(int id) {
        return triples[id];
    }

    public String toString() {
        return "[Triple id = " + id + "]";
    }
}
