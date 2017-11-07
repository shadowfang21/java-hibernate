package com.sf.learning.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.learning.hibernate.dao.CompanyDAO;
import com.sf.learning.hibernate.model.Company;

@Repository
public class CompanyHibernateDAOImpl implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listAll() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		List<Company> result = new ArrayList<Company>();
		try {
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public Company getById(long id) {
		
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		Company result = null;
		try {
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void deleteById(long id) {
		final Session session = sessionFactory.openSession();	
		
		try {
			
			
			
			
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Company update(Company company) {
		final Session session = sessionFactory.openSession();	
		try {
			
			
			
			
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
	}

	@Override
	public Company create(Company company) {
		final Session session = sessionFactory.openSession();	
		try {
			
			
			
			
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
	}

	@Override
	public List<Company> findByAddress(final String address) {
		return this.queryByCriteria(address);
	}
	
	@SuppressWarnings("unchecked")
	protected List<Company> queryByCriteria(final String address) {
		
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		List<Company> result = new ArrayList<Company>();
		try {

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected List<Company> queryBySql(final String address) {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		List<Company> result = new ArrayList<Company>();
		try {

			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected List<Company> queryByHql(final String address) {
		
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		List<Company> result = new ArrayList<Company>();
		try {
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
