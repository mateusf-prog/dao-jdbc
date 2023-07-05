package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Main2 {
    public static void main(String[] args) {

        Department dep1 = new Department(5, "Music");

        DepartmentDao dep = DaoFactory.createDepartmentDao();

        dep.insert(dep1);

        System.out.println("--- test 1 insert ---");
        System.out.println("insert ok!");

        System.out.println("\n--- test 2 findById ---");
        if (dep.findById(1) != null) {
            System.out.println("test ok!");
            System.out.println(dep.findById(1));
        } else {
            System.out.println("Not found");
        }

        System.out.println("\n--- test 3 update ---");
        dep1 = dep.findById(2);
        dep1.setName("Items");
        dep.update(dep1);
        System.out.println("test ok!");

        System.out.println("\n--- test 4 findAll ---");
        for (Department obj : dep.findAll()) {
            System.out.println(obj);
        }
        System.out.println("test ok!");

        System.out.println("\n--- test 5 delete ---");
        dep.deleteById(21);
        System.out.println("test ok!");
    }
}
