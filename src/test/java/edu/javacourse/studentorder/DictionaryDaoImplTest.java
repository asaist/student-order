package edu.javacourse.studentorder;



import edu.javacource.studentorder.dao.DictionaryDaoImpl;
import edu.javacource.studentorder.domain.CountryArea;
import edu.javacource.studentorder.domain.PassportOffice;
import edu.javacource.studentorder.domain.RegisterOffice;
import edu.javacource.studentorder.domain.Street;
import edu.javacource.studentorder.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.time.LocalDateTime;
import java.util.List;

@Slf4j

public class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.StartUp();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        log.debug("TEST {} {}",dt1, dt2);
        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(d.size() == 2);
   }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        Assert.assertTrue(ro.size() == 2);
    }
    @Test
    public void testArea() throws DaoException {

        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);

    }


}