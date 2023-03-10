package Tema;

public class Assistant extends User implements Element{
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
