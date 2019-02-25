package com.why.dao;

import com.why.CaffeineApplication;
import com.why.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: why
 * @Data:2018/12/7
 * @Deacription:
 */

@SpringBootTest(classes = CaffeineApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class PersonDAOTest {
    @Resource
    private PersonDAO pDao;

    @Test
    public void getPersonById() {

        List<Person> p= pDao.getPersonById();
        System.out.println(p.toString());

    }

    @Test
    public void insertPerson() {
        Person p=new Person();
           p.setFirstName("ss");
           p.setLastName("dddd");
           p.setPhoneNo("124569878900");
           p.setBirthDate(new Date());
           p.setSex('n');
        pDao.insertPerson( p);
    }

    @Test
    public void updatePersonById() {
    }

    @Test
    public void updatePersonByPhoneNo() {
    }

    @Test
    public void selectUnionPerson() {
    }
}