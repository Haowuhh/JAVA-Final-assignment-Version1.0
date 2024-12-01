
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeService {
    private static String filePath = "D:\\Project\\Java\\termFinal\\EmployeeInfo";
    public static boolean insertEmpInfo(String name, String gender, String ID, Date date, String Wno, String tel, String Dept, Double salary) throws FileNotFoundException {
        File file = new File(filePath);
        if (file.length() == 0) {
            try {
                ArrayList<Employee> employeeList = new ArrayList<>();
                employeeList.add(new Employee(name, gender, ID, date, Wno, tel, Dept, salary));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
                objectOutputStream.writeObject(employeeList);
                System.out.println("Object has been serialized and written to person.ser file.");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        } else {
                ArrayList<Employee> EmpList = (ArrayList<Employee>) SelectEmpFunction.deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");
                EmpList.add(new Employee(name, gender, ID, date, Wno, tel, Dept, salary));
                SelectEmpFunction.serializeEmployee(EmpList, "D:\\Project\\Java\\termFinal\\EmployeeInfo");
                return true;
        }
    }

    public static void selectEmpInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要的查询功能");
        System.out.println("1,根据工号精确查询职工信息\n2,根据姓名、科室查询职工信息\n3,分科室进行工资统计，计算各科室的平均工资");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println(SelectEmpFunction.ByWno(scanner.next()));
                break;
            case 2:
                System.out.println(SelectEmpFunction.ByNameAndDept(scanner.next(), scanner.next()));
                break;
            case 3:
                System.out.println(SelectEmpFunction.calculateAveSalaryGroupByDept());
            default:
                break;
        }
    }

    public static void printEmpInfoBySalary() {
        ArrayList<Employee> EmpList = (ArrayList<Employee>) SelectEmpFunction.deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");

        // 使用自定义的 Comparator 进行排序
        Collections.sort(EmpList, new EmployeeSalaryComparator());

        for (Employee emp : EmpList) {
            System.out.println(emp);
        }
    }

    public static void changeEmpInfoByNo(String Wno) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Employee> EmpList = (ArrayList<Employee>) SelectEmpFunction.deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");

        Employee empToChange = null;

        int index = 0;
        for (Employee emp : EmpList) {
            if (emp.getWno().equals(Wno)) {
                empToChange = emp;
                break;  // 找到后退出循环
            }
            index++;
        }

        //修改匹配的对象
        if (empToChange != null) {
            System.out.println("请输入要更改的信息：\n输入先后顺序：姓名，性别，ID，生日（分年月日），电话号码，部门，月薪");
            EmpList.set(index, new Employee(scanner.next(), scanner.next(), scanner.next(), new Date(scanner.next(), scanner.next(), scanner.next()), Wno, scanner.next(), scanner.next(), scanner.nextDouble()));
            System.out.println("Employee with Wno " + Wno + " has been changed.");
        } else {
            System.out.println("Employee with Wno " + Wno + " not found.");
        }

        SelectEmpFunction.serializeEmployee(EmpList, "D:\\Project\\Java\\termFinal\\EmployeeInfo");
    }


    public static void deleteEmployeeByWno(String Wno) {
        // 1. 反序列化文件中的 ArrayList
        ArrayList<Employee> employees = (ArrayList<Employee>) SelectEmpFunction.deserializeEmployee("D:\\Project\\Java\\termFinal\\EmployeeInfo");

        // 2. 找到并删除 Wno 匹配的 Employee 对象
        Employee empToRemove = null;
        for (Employee emp : employees) {
            if (emp.getWno().equals(Wno)) {
                empToRemove = emp;
                break;  // 找到后退出循环
            }
        }

        // 3. 删除匹配的对象
        if (empToRemove != null) {
            employees.remove(empToRemove);
            System.out.println("Employee with Wno " + Wno + " has been removed.");
        } else {
            System.out.println("Employee with Wno " + Wno + " not found.");
        }

        // 4. 重新序列化保存修改后的 ArrayList
        SelectEmpFunction.serializeEmployee(employees, "D:\\Project\\Java\\termFinal\\EmployeeInfo");
    }



}
