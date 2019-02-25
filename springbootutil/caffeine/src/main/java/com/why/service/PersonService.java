package com.why.service;

import com.github.pagehelper.PageHelper;
import com.why.dao.PersonDAO;
import com.why.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private PersonDAO personDao;
	

	/**
	 * 根据id获取Person对象，使用缓存
	 * @param id
	 * @return Person对象
	 */
	@Cacheable(value="getPersonById", sync=true)
	public List<Person> getPersonById(int id){
		logger.info("getting data from database, personId={}", id);
		PageHelper.startPage(id,1);
		return personDao.getPersonById();
	}
	
}
