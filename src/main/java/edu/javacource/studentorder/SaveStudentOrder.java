package edu.javacource.studentorder;

import edu.javacource.studentorder.dao.DictionaryDaoImpl;
import edu.javacource.studentorder.dao.StudentOrderDao;
import edu.javacource.studentorder.dao.StudentOrderDaoImpl;
import edu.javacource.studentorder.domain.*;
import edu.javacource.studentorder.exception.DaoException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws ExceptionInInitializerError, ClassNotFoundException, SQLException, DaoException {



//          StudentOrder s = buildStudentOrder(10);
          StudentOrderDao dao = new StudentOrderDaoImpl();
//          Long id = dao.saveStudentOrder(s);
//          System.out.println(id);

          List<StudentOrder> soList =  dao.getStudentOrders();
          for (StudentOrder so : soList){
              System.out.println(so.getStudentOrderId());
          }
//        StudentOrder so1 = new StudentOrder();
//        long ans1 = saveStudentOrder(so1);
//        System.out.println(ans1);


    }
    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder:");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016,7,4));
        RegisterOffice ro = new RegisterOffice(1L,"","");
        so.setMarriageOffice(ro);

        Street street = new Street(1L,"First street");

        Address address = new Address("195000", street, "12", "", "142");


        //Муж
        Adult husband = new Adult("Петров","Виктор","Сергеевич", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        PassportOffice po1 = new PassportOffice(1L,"","");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L,""));
        husband.setStudentId("HH12345");

        //Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998,3,12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        PassportOffice po2 = new PassportOffice(2L,"","");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L,""));
        wife.setStudentId("WW12345");

        //Ребенок
        Child child1 = new Child("Петрова","Ирина", "Викторовна", LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,11));
        RegisterOffice ro2 = new RegisterOffice(2L,"","");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);

        //Ребенок
        Child child2 = new Child("Петров","Евгений", "Викторович", LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        RegisterOffice ro3 = new RegisterOffice(3L,"","");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }

    static void printStudentOrder(StudentOrder so){
        System.out.println(so.getStudentOrderId());
    }


}
