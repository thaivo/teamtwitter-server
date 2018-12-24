package com.musicmanager.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.musicmanager.dao.SongDao;
import com.musicmanager.model.Song;

public class SongDaoImpl implements SongDao{
	
	//HibernateTransactionManager transactionManager;
	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	public void saveMusic(Song music) {
		/*Session session = transactionManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(music);
		tx.commit();
		session.close();*/
		template.save(music);
		System.out.print("\nthis.sessionFactory.getCurrentSession().save(music) \n");
		/*this.sessionFactory.getCurrentSession().beginTransaction();
		this.sessionFactory.getCurrentSession().save(music);
		this.sessionFactory.getCurrentSession().getTransaction().commit();
		this.sessionFactory.getCurrentSession().close();*/
		
	}
	 
	public void updateMusic(Song music) {
//		 this.sessionFactory.getCurrentSession().update(music);
	}
	 
	public void deleteMusic(Song music) {
//		 this.sessionFactory.getCurrentSession().delete(music);
	}
/*	
	public Song getById(int id) {
		return (Song)this.sessionFactory.getCurrentSession().get(Song.class, id);
	}*/
	
	public ArrayList<Song> getSongs(){
		ArrayList<Song> list =  new ArrayList<Song>();
		//Session session = transactionManager.getSessionFactory().openSession();
		//Transaction tx = session.beginTransaction();
		//System.out.print("\n getSongs 1 \n");
		//list = (ArrayList<Song>) ((HibernateTemplate) this.sessionFactory.getCurrentSession()).loadAll(Song.class);
		//list = (ArrayList<Song>) ((HibernateTemplate)session).loadAll(Song.class);
		list = (ArrayList<Song>)template.loadAll(Song.class);
		//System.out.print("\n getSongs 2 \n");
		return list;
	}


public Song getById(int id) {
	// TODO Auto-generated method stub
	return null;
}
	
}
