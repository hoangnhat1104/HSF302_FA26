package fu.de190259;

import fu.de190259.dao.EmployeeDAO;
import fu.de190259.pojo.Employee;
import fu.de190259.pojo.Gender;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsf302FU");
        System.out.println("EMF tao thanh cong!");

        // TODO3 — TEST CREATE
        EmployeeDAO dao = new EmployeeDAO(emf);

        Employee e = new Employee();
        e.setFullName("Nguyen Van A");
        e.setEmail("vana@gmail.com");
        e.setPhone("0901234567");
        e.setSalary(15000000);
        e.setBirthDate(LocalDate.of(2000, 1, 15));
        e.setGender(Gender.MALE);
        e.setActive(true);

        System.out.println("Before save - ID: " + e.getId()); // 0 (chưa có ID)

        dao.save(e);

        System.out.println("After save  - ID: " + e.getId()); // ID do DB sinh ra (khác 0)

        emf.close();
    }
}
