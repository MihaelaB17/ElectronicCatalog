package Tema;

public class UserFactory {

    public static User getUser(String userType, String firstName, String lastName ){
        if(userType.equals("Student"))
            return new Student(firstName, lastName);
        if(userType.equals("Parent"))
            return new Parent(firstName, lastName);
        if(userType.equals("Assistant"))
            return new Assistant(firstName, lastName);
        if(userType.equals("Teacher"))
            return new Teacher(firstName, lastName);
        return  null;
    }
}
