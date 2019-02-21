package com.why.dao;

import com.why.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface PersonDAO {
	
	@Select("SELECT id, first_name AS firstName, last_name AS lastName, birth_date AS birthDate, sex, phone_no AS phoneNo"
			+ " FROM person ")
	 List<Person> getPersonById();
	
	 int insertPerson(Person person);
	
	 int updatePersonById(Person person);

	 int updatePersonByPhoneNo(Person person);

	List<Person> selectUnionPerson(@Param("ids") List<Integer> ids);
}
