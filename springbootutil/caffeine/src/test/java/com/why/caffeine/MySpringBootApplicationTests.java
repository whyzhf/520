package com.why.caffeine;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.why.config.MyProps;
import com.why.dao.PersonDAO;
import com.why.entity.Person;
import com.why.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class MySpringBootApplicationTests extends BasicUtClass{
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private MyProps myProps; 
	
	@Test
	public void common() throws JsonProcessingException{
		//JSONObject o = new JSONObject();
		//objectMapper.readValue(src, valueType)
		Map<String, Object> m = new HashMap<>();
		m.put("k", "<我是中文>");
		String s = objectMapper.writeValueAsString(m);
		System.out.println(s);
	}
	
	@Test
	public void propsTest() throws JsonProcessingException {
		System.out.println("simpleProp: " + myProps.getSimpleProp());
		System.out.println("arrayProps: " + objectMapper.writeValueAsString(myProps.getArrayProps()));
		System.out.println("listProp1: " + objectMapper.writeValueAsString(myProps.getListProp1()));
		System.out.println("listProp2: " + objectMapper.writeValueAsString(myProps.getListProp2()));
		System.out.println("mapProps: " + objectMapper.writeValueAsString(myProps.getMapProps()));
	}
	
	@Test 
	public void logTest(){
		//MainMapLookup.setMainArguments("projectName", "test-project-name");
		/*logger.trace("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.error("I am error log.");
		logger.info("I am info log.");*/
		String Str="123456";
		System.out.println(Str.subSequence(0, Str.indexOf("_")) );
	}

	@Test
	public void dbTest() throws JsonProcessingException{
	/*	List<Person>person2 = personDAO.getPersonById(2);
		logger.info("person no 2 is: {}", objectMapper.writeValueAsString(person2));
		
		person2.setFirstName("八八");
		personDAO.updatePersonById(person2);
		person2 = personDAO.getPersonById(2);
		logger.info("person no 2 after update is: {}", objectMapper.writeValueAsString(person2));
		assertThat(person2.getFirstName(), equalTo("八八"));

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Person> people = personDAO.selectUnionPerson(ids);
        logger.info("union person: {}", objectMapper.writeValueAsString(people));*/
    }


	@Autowired
	PersonService personService;
	
	@Test
	public void localCacheTest() throws JsonProcessingException, InterruptedException{
		System.out.println("第一次："); //从数据库中获取
		List<Person> p = personService.getPersonById(0);
		logger.info("1st time: {}", objectMapper.writeValueAsString(p));
		
		System.out.println("第二次："); //从缓存中获取
		p = personService.getPersonById(1);
		logger.info("2nd time: {}", objectMapper.writeValueAsString(p));
		
		Thread.sleep(50000);
		
		System.out.println("第三次："); //5秒钟超时后，从数据库中获取
		p = personService.getPersonById(2);
		logger.info("3rd time: {}", objectMapper.writeValueAsString(p));

		System.out.println("第四次："); //从缓存中获取
		p = personService.getPersonById(2);
		logger.info("4th time: {}", objectMapper.writeValueAsString(p));

	}
	
	
/*	@Autowired
	VelocityEngine velocityEngine;
	
	@Test
	public void velocityTest(){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("time", XDateUtils.nowToString());
		model.put("message", "这是测试的内容。。。");
		model.put("toUserName", "张三");
		model.put("fromUserName", "老许");
		System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "welcome.vm", "UTF-8", model));
	}*/

}
