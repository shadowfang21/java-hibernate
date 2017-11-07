package com.sf.learning.hibernate;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class ORMQueryDemo {
	
	//don't ever do this in real world
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) throws BeansException, Exception {
		final ConfigurableApplicationContext context = 
				new SpringApplicationBuilder(ORMQueryDemo.class)
					.headless(false)
					.run(args);
		
		final ORMQueryDemo demo = context.getBean(ORMQueryDemo.class);
		
//		demo.listAllArticleType();
		demo.listAllComment();
//		demo.listAllCommentSelectAfterClose();
//		demo.listAllCategory();
//		demo.listAllArticle();
//		demo.listAllArticleN1();
	}

	public void listAllArticleType() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		try {
			final List<ArticleType> result = 
					session.createCriteria(ArticleType.class)
						.list();
			
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void listAllComment() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		List<Comment> result = null;
		try {
			result = session.createCriteria(Comment.class)
						.setFetchMode("article", FetchMode.SELECT)
						.list();

			System.out.println("comment size : " + result.size());
//			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void listAllCommentSelectAfterClose() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		
		try {
			final List<Comment> result = session.createCriteria(Comment.class)
						.setFetchMode("article", FetchMode.SELECT)
						.list();

			System.out.println("comment size : " + result.size());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void listAllCategory() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		try {
			final List<Category> result = 
					session.createCriteria(Category.class)
					.list();
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void listAllArticle() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		try {
			final List<Article> result = 
					session.createCriteria(Article.class)
					.setFetchMode("comment", FetchMode.JOIN)
					.setFetchMode("category", FetchMode.JOIN)
					.list();
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void listAllArticleN1() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		try {
			final List<Article> result = 
					session.createCriteria(Article.class)
					.setFetchMode("comment", FetchMode.SELECT)
					.list();
			
			//show all comment, N+1
			for (Article article : result) {
				System.out.println(article.getComment());
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
