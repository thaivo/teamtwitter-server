package com.musicmanager.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.musicmanager.dao.SongDao;
import com.musicmanager.model.Song;

public class SongDaoImpl extends HibernateDaoSupport  implements SongDao{
	
	HibernateTransactionManager transactionManager;
	/*HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
*/
	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

		/*private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	//@Transactional(readOnly = false)
	public void saveMusic(Song music) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(music);
		
	}
	 
	public void updateMusic(Song music) {
//		 this.sessionFactory.getCurrentSession().update(music);
	}

	public void deleteMusic(Song music) {
		Session session = transactionManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(music);
		tx.commit();
		session.close();
	}

	public ArrayList<Song> getSongs(){
		ArrayList<Song> list =  new ArrayList<Song>();
		getHibernateTemplate().setCheckWriteOperations(false);
		list = (ArrayList<Song>)getHibernateTemplate().loadAll(Song.class);
		
		//System.out.print("\n getSongs 2 \n");
		return list;
	}

	public Song findSongById(int id) {
	// TODO Auto-generated method stub
		getHibernateTemplate().setCheckWriteOperations(false);	
	return getHibernateTemplate().load(Song.class, id);
}
	
}
