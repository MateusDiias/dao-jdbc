package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Seller findById:");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\nSeller findByDepartment:");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj :
                list) {
            System.out.println(obj);
        }

        System.out.println("\nSeller findAll:");
        list = sellerDao.findAll();
        for (Seller obj :
                list) {
            System.out.println(obj);
        }

        System.out.println("\nSeller insert:");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("New id: " + newSeller.getId());

        System.out.println("\nSeller update:");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated completed");

        System.out.println("\nSeller delete:");
        seller = sellerDao.findById(2);
        sellerDao.deleteById(seller.getId());
        System.out.println("Seller deleted");
    }
}
