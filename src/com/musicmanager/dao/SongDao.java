package com.musicmanager.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.musicmanager.model.Song;


public interface SongDao {
	/*public void setFlushMode();

	

	public HibernateTemplate getTemplate(); 

	public void setTemplate(HibernateTemplate template);

	public HibernateTransactionManager getTransactionManager();

	public void setTransactionManager(HibernateTransactionManager transactionManager);
	*/ 
	public void saveMusic(Song music);
	
	public void updateMusic(Song music);
	
	public void deleteMusic(Song music) ;
	
	public Song getById(int id);
	
	public ArrayList<Song> getSongs();
}


