package fpdemo.pd;

import java.util.function.Consumer;

public class TrainJourny {
    private int price;
    private TrainJourny onward;

    public TrainJourny(int price, TrainJourny onward) {
        this.price = price;
        this.onward = onward;
    }

    public static void main(String[] args) {
        TrainJourny tj1 = new TrainJourny(30, new TrainJourny(40, null));
        TrainJourny tj2 = new TrainJourny(20, new TrainJourny(50, null));

        Consumer<TrainJourny> c = tj -> System.out.print(tj.price+ ", "); 

        visit(tj1, c);
        System.out.println();
        visit(tj2, c);
        System.out.println();

        // TrainJourny linked = link(tj1, tj2);
        // visit(linked,c);
        // System.out.println();

        // TrainJourny linked2 = link(tj1, tj2);
        // visit(linked2,c);
        // System.out.println();

        TrainJourny appended = append(tj1, tj2);
        visit(appended,c);
        System.out.println();

        TrainJourny appended2 = append(tj1, tj2);
        visit(appended2,c);
        System.out.println();

        TrainJourny appended3 = append(tj1, tj2);
        visit(appended3,c);
        System.out.println();


        
    }

    public static TrainJourny append(TrainJourny a, TrainJourny b) {
        return (a == null) ? b : new TrainJourny(a.price, append(a.onward, b));
    }

    public static TrainJourny link(TrainJourny a, TrainJourny b) {
        if (a == null) {
            return b;
        }

        TrainJourny t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    public static void visit(TrainJourny tj, Consumer<TrainJourny> c) {
        if ( tj != null) {
            c.accept(tj);
            visit(tj.onward, c);
        }
    }

}
