package Tema;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public Student executeStrategy(Course c){
        return strategy.doOperation(c);
    }
}
