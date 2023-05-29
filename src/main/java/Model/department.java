package Model;

public class department {
    private  int department_id;
    private String name;

    public department(int department_id, String name) {
        this.department_id = department_id;
        this.name = name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
