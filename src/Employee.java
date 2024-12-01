import java.io.Serializable;

public class Employee extends Person implements Serializable{
    private String Wno;
    private String tel;
    private String Dept;
    private double salary;

    public Employee() {

    }

    public Employee(String name, String gender, String ID, Date date, String Wno, String tel, String Dept, double salary) {
        super(name, gender, ID, date);
        this.Wno = Wno;
        this.tel = tel;
        this.Dept = Dept;
        this.salary = salary;
    }

    public String getWno() {
        return Wno;
    }

    public void setWno(String wno) {
        this.Wno = wno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Dept='" + Dept + '\'' +
                ", Wno=" + Wno +
                ", tel=" + tel +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", ID='" + ID + '\'' +
                ", date=" + date +
                '}';
    }


}
