package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1 Seller findById ===");

        Seller seller = sellerDao.findById(7);

        System.out.println(seller);

        System.out.println("\n=== Test 2 Seller findByDepartment===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3 Seller findAll===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4 Seller insert===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com",
                new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== Test 5 Seller update===");
        seller = sellerDao.findById(1);
        seller.setName("Matthew");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n=== Test 6 Seller delete===");
        sellerDao.deleteById(11);
        System.out.println("Delete completed!");
    }
}