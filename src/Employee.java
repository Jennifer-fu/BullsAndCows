/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-2-14
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
public class Employee {
        private int type;
        private int monthlySalary;
        private int commission;
        private int bonus;

        private final int Engineer = 0;
        private final int Salesman = 1;
        private final int Manager = 2;

        public Employee(int type, int monthlySalary, int commission, int bonus) {
            this.type = type;
            this.monthlySalary = monthlySalary;
            this.commission = commission;
            this.bonus = bonus;
        }

        int Payment() {
            switch (type) {
                case Engineer:
                    return monthlySalary;
                case Salesman:
                    return monthlySalary+commission;
                case Manager:
                    return monthlySalary+bonus;
                default:
                    throw new RuntimeException("Incorrect Employee");
            }
        }
}
