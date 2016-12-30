package btn.k23.dhcantho.db4odatabase;

/**
 * Created by sonlonglxag on 11/21/16.
 */

public class Person {
    //vars
    public String name;
    public int number;
    public String email;

    //empty constructor
    public Person(){}

    //constructor for a retrieve operation
    public Person(String name, int number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String toString(){
        return  (name+" "+number+" "+email);
    }
}
