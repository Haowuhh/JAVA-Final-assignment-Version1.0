import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectEmpFunction {
    public static ArrayList<Employee> ByWno(String Wno) {
        ArrayList<Employee> EmpList = (ArrayList<Employee>) deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");
        if (EmpList == null) {
            throw new IllegalStateException("Failed to deserialize Employee data. EmpList is null.");
        }

        ArrayList<Employee> resList = new ArrayList<>();
        for (Employee employee : EmpList) {
            System.out.println("Checking employee with Wno: " + employee.getWno());
            if (Wno.equals(employee.getWno())) { // 避免 null 异常
                resList.add(employee);
            }
        }
        return resList; // 即使没有匹配的员工，返回空列表而不是 null
    }


    public static ArrayList<Employee> ByNameAndDept(String name, String dept) {
        ArrayList<Employee> EmpList = (ArrayList<Employee>) deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");
        if (EmpList == null) {
            throw new IllegalStateException("Failed to deserialize Employee data. EmpList is null.");
        }
        ArrayList<Employee> resList = new ArrayList<>();
        for(Employee employee : EmpList) {
            if (name.equals(employee.getName()) && dept.equals(employee.getDept())) {
                resList.add(employee);
            }
        }
        return resList;
    }

    public static ArrayList<Employee> calculateAveSalaryGroupByDept() {
        List<Employee> EmpList = deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");
        Map<String, Double> salaryInfo = new HashMap<>();
        for(Employee employee : EmpList) {
            salaryInfo.put(employee.getDept(), salaryInfo.getOrDefault(employee.getSalary(), 0.0) + 1);
        }
        return null;
    }

    public static List<Employee> deserializeEmployee(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = in.readObject(); // 一次性读取整个对象
            System.out.println("Read object of type: " + obj.getClass());

            // 直接将读取到的对象强制转换为 List<Employee>
            return (List<Employee>) obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // 如果反序列化失败，返回空列表
    }


    // 将更新后的 ArrayList 写回文件
    public static void serializeEmployee(List<Employee> employees, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(employees);  // 将 ArrayList<Employee> 序列化写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

