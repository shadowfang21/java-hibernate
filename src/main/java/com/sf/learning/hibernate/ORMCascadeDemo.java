package com.sf.learning.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.sf.learning.hibernate.model.Article;
import com.sf.learning.hibernate.model.ArticleType;
import com.sf.learning.hibernate.model.Category;
import com.sf.learning.hibernate.model.Comment;
import com.sf.learning.hibernate.model.Company;

@Component
@ImportResource({"classpath:spring-config/module/applicationContext.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-common.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-manager.xml"})
public class ORMCascadeDemo {
	
	//don't ever do this in real world
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) throws BeansException, Exception {
		final ConfigurableApplicationContext context = 
				new SpringApplicationBuilder(ORMCascadeDemo.class)
					.headless(false)
					.run(args);
		
		final ORMCascadeDemo demo = context.getBean(ORMCascadeDemo.class);
		
		final ArticleType articleType = new ArticleType();
		articleType.setArticleTypeId(1);
		
		final Category categoryHibernate = new Category();
		categoryHibernate.setCategoryId(2);
		final Category categorySpring = new Category();
		categorySpring.setCategoryId(3);
		
		final Article article = new Article();
		article.setArticleType(articleType);
		article.setContent("insert new article");
		article.setTitle("insert new article");
		
		article.getCategory().add(categorySpring);
		article.getCategory().add(categoryHibernate);
		
		final Comment comment1 = new Comment();
		comment1.setArticle(article);
		comment1.setText("text1");
		final Comment comment2 = new Comment();
		comment2.setArticle(article);
		comment2.setText("text2");
		
		article.getComment().add(comment1);
		article.getComment().add(comment2);
		
		demo.crateArticle(article);
		
		//if you set cascade=save-update. you don't need this anymore
		demo.crateComment(comment1);
		demo.crateComment(comment2);
	}
	
	public void crateComment(final Comment comment) {
		
		final Session session = sessionFactory.openSession();
		try {
			session.save(comment);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void crateArticle(final Article article) {
		
		final Session session = sessionFactory.openSession();
		try {
			session.save(article);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
