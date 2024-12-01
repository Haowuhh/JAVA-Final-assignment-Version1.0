import java.io.Serializable;

public class Person implements Serializable {
     String name;
     String gender;
     String ID;
     Date date;

     public Person() {

     }

    public Person(String name, String gender, String ID, Date date) {
        this.name = name;
        this.gender = gender;
        this.ID = ID;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
