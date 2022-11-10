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

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder:");
        return answer;
    }


    static void printStudentOrder(StudentOrder so){
        System.out.println(so.getStudentOrderId());
    }


}
