package leave.nucleus.spring;

public abstract class Manager {

    protected void create(EmployeeDTO employee) {
        System.out.println("Method create() called");
    }

    protected void delete(Integer employeeId) throws Throwable {
        System.out.println("Method delete() called");
        throw new NullPointerException();
    }

    public void update(EmployeeDTO employee) {
        System.out.println("Method update() called");
    }

}
