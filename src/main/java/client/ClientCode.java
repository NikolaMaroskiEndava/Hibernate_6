package client;

import jakarta.persistence.EntityManager;
import model.Department;
import model.Employee;
import org.hibernate.Incubating;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.Dialect;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;
import util.HibernateUtil;

import java.time.*;
import java.util.List;

public class ClientCode {

    private final EntityManager entityManager;

    public ClientCode(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {
        getDatabaseVersionAndHibernateDialect();
        persistEntitiesHibernate();
        getZoneDateTimeOffset();
    }

    private static void getDatabaseVersionAndHibernateDialect() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Object result = session.createSelectionQuery(" select version()", Object.class).getSingleResult();
            System.out.println("My database version is::: \n" + result);

            SessionFactoryImpl sessionFactory = (SessionFactoryImpl) session.getSessionFactory();
            Dialect dialect = sessionFactory.getJdbcServices().getDialect();
            System.out.println("My hibernate dialect is::: \n" + dialect);

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void persistEntitiesHibernate() {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            /** Add Employee to db **/
//            Employee employee = new Employee();
//            employee.setId(3);
//            employee.setName("Hibernate 6.3.1");
//            employee.setEmail("hibernate6@hibernate.com");
//            employee.setPhone(3897745565466L);
//            session.persist(employee);

            /** Add Department to db **/
//            Employee e1 = session.find(Employee.class, 1);
//            Employee e2 = session.find(Employee.class, 2);
//            Employee e3 = session.find(Employee.class, 3);
//            Employee e4 = session.find(Employee.class, 4);
//
//            ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+5"));
//            OffsetDateTime odt = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(5));
//            Department department = new Department();
//            department.setName("Department No.34");
//            department.setDepartmentEmployees(List.of(e3,e4));
//            department.setActive(true);
//            department.setZonedDateTime(zdt);
//            department.setOffsetDateTime(odt);
//            session.persist(department);

            /** Retrieve Employee from db **/
//            Employee e = session.get(Employee.class, 2);
//            System.out.println(e);

            /** Retrieve Department from db **/
//            Department department = session.get(Department.class, 652);
//            List<Employee> employees = department.getDepartmentEmployees();
//            employees.forEach(System.out::println);

            /** Using Selection Query successfully **/
//            SelectionQuery<Employee> selectionQuery = session.createSelectionQuery("SELECT e FROM Employee e", Employee.class);
//            List<Employee> employees = selectionQuery.getResultList();
//            employees.forEach(System.out::println);

            /** Using Selection Query failed **/
//            SelectionQuery<Employee> selectionQuery1 = session.createSelectionQuery("UPDATE Employee SET name = upper(name)", Employee.class);
//            List<Employee> employees1 = selectionQuery1.getResultList();
//            employees1.forEach(System.out::println);

            /** Using Mutation Query upper(name) successfully **/
//            MutationQuery mutationQuery = session.createMutationQuery("UPDATE Employee SET name=upper(name)");
//            mutationQuery.executeUpdate();

//            /** Using Mutation Query lower(name) successfully **/
//            MutationQuery mutationQuery = session.createMutationQuery("UPDATE Employee SET name=lower(name)");
//            mutationQuery.executeUpdate();

            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    private static void getZoneDateTimeOffset() {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Department department = session.get(Department.class, 402);
            System.out.println(department);

            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

}
