package com.musicmanager.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.musicmanager.model.Song;


public interface SongDao{
	
	public void saveMusic(Song music);
	
	public void updateMusic(Song music);
	
	public void deleteMusic(Song music) ;
	
	public Song findSongById(int id);
	
	public ArrayList<Song> getSongs();
}


