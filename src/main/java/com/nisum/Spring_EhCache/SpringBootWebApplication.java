package com.nisum.Spring_EhCache;

import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nisum.bo.Movie;
import com.nisum.bo.Person.Gender;
import com.nisum.dao.MovieDaoImpl;
import com.nisum.dao.RndPolicy;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.SearchAttribute;
import net.sf.ehcache.config.Searchable;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Direction;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import net.sf.ehcache.store.AbstractPolicy;

@EnableCaching
@SpringBootApplication
@ComponentScan("com.nisum.*")
public class SpringBootWebApplication {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootWebApplication.class, args);
		MovieDaoImpl dao = (MovieDaoImpl) ctx.getBean("mdi");
		Cache cache = CacheManager.getInstance().getCache("movieFindCache");
		cache.setMemoryStoreEvictionPolicy(new RndPolicy());
		dao.saveMovie(1,"Puri","DCM");
		dao.saveMovie(2,"Trivikram","AV");
		System.out.println(dao.findByDirector("Puri").toString());
		dao.saveMovie(3,"SS","BB");
//		System.out.println("Puri 2"+dao.findByDirector("Puri").toString());
//		System.out.println(dao.findByDirector("Trivikram").toString());
//		dao.saveMovie(4,"EVV","BB");
//		System.out.println("Puri 2"+dao.findByDirector("Puri").toString());
//		System.out.println(dao.findByDirector("SS").toString());
//		System.out.println(dao.findByDirector("Puri").toString());
//				System.out.println(dao.findByDirector("SS").toString());
//		//
//		//		System.out.println(dao.findByDirector("VVV").toString());
//		//
//		//		System.out.println(dao.findByDirector("EVV").toString());
//
//
//		//		Searchable searchable = new Searchable();
//		//		searchable.addSearchAttribute(new SearchAttribute().name("name"));
//		Cache cache = CacheManager.getInstance().getCache("movieFindCache");
//		Attribute<String> nameAttr = cache.getSearchAttribute("name");
//		Query query = cache.createQuery();
//		query.includeKeys();
//		query.includeValues();
//		query.addCriteria(nameAttr.ilike("Puri"));
//
//		Results results = query.execute();
//		System.out.println(" Size: " + results.size());
//		System.out.println("----Results-----\n");
//		for (Result result : results.all()) {
//			Movie mv = (Movie)result.getValue();
//			System.out.println("Got: Key[" + result.getKey()+"]"+mv.getDirectory()+"-"+mv.getId());
//		}
//
	}
@Bean(name="ep")
public AbstractPolicy registerBean() {
	return new RndPolicy();
}
}

