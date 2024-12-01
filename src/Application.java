
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        init();
    }

    public static void init() throws FileNotFoundException {
        System.out.println("----------欢迎来到职工工资管理系统----------");
        System.out.println("1,输入员工信息\n2,查询\n3,根据职工的工资排序输出\n4,根据工号修改职工信息\n5,根据工号删除职工信息\n6,退出");
        fuctionService();
    }

    public static void fuctionService() throws FileNotFoundException {
        switch (scanner.nextInt()) {
            case 1:
                EmployeeService.insertEmpInfo(scanner.next(), scanner.next(), scanner.next(), new Date(scanner.next(), scanner.next(), scanner.next()), scanner.next(), scanner.next(), scanner.next(), scanner.nextDouble());
                break;
            case 2:
                EmployeeService.selectEmpInfo();
                break;
            case 3:
                EmployeeService.printEmpInfoBySalary();
                break;
            case 4:
                System.out.println("请输入更改信息的员工的工号");
                EmployeeService.changeEmpInfoByNo(scanner.next());
                break;
            case 5:
                System.out.println("请输入删除信息的员工的工号");
                EmployeeService.deleteEmployeeByWno(scanner.next());
                break;
            case 6:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}

