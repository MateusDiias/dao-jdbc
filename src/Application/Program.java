package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\nSeller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj :
                list) {
            System.out.println(obj);
        }

        System.out.println("\nSeller findAll");
        list = sellerDao.findAll();
        for (Seller obj :
                list) {
            System.out.println(obj);
        }
    }
}
