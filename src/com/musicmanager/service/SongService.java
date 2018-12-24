/* ************************************************************************

   qooxdoo - the new era of web development

   http://qooxdoo.org

   Copyright:
     2006-2007 STZ-IDA, Germany, http://www.stz-ida.de

   License:
     LGPL: http://www.gnu.org/licenses/lgpl.html
     EPL: http://www.eclipse.org/org/documents/epl-v10.php
     See the LICENSE file in the project's top-level directory for details.

   Authors:
     * Andreas Junghans (lucidcake)

************************************************************************ */

package com.musicmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.FlushMode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.musicmanager.dao.SongDao;
import com.musicmanager.dao.impl.SongDaoImpl;
import com.musicmanager.model.Song;

import net.sf.qooxdoo.rpc.Environment;

public class SongService implements RemoteService {
	
	private Environment _env;
	private SongDao songDao;
    public void setQooxdooEnvironment(Environment env) {
        _env = env;
    }

    public void someRemoteMethod() throws RemoteServiceException {
        HttpSession session = _env.getRequest().getSession();
    }
    //@Transactional
	public String insertSong(HashMap<String, String> input) throws RemoteServiceException {
		String ret = "";
		try {
			 Resource r=new ClassPathResource("applicationContext.xml");  
			    BeanFactory factory=new XmlBeanFactory(r);  
			      
			    this.songDao=factory.getBean(SongDaoImpl.class);
			    //HibernateTransactionManager htx = (HibernateTransactionManager) factory.getBean("transactionManager");
			    
			    
			    System.out.print("before input.getString(\"name\") \n");
			    //System.out.print(arr);
			    String nameOfSong = input.get("name");
			    System.out.print(nameOfSong);
			    System.out.print("\nbefore input.getString(\"author\") \n");
			    String author =input.get("author");
			    System.out.print(nameOfSong);
			    //this.songDao.setTransactionManager(htx);
			    Song song = new Song(nameOfSong, author);
			    //Song song = new Song(new String("123"), new String("thai123"));
			    System.out.print("\nbefore call saveMusic ");
			    if(this.songDao == null) System.out.print("this.songDao is null");
			    this.songDao.saveMusic(song);
			    
			    
			    ArrayList<Song> song1 = this.songDao.getSongs();
			    ret = "inserted Song: " + song1.get(0).getName() + " by " + song1.get(0).getAuthor();
			    ret += "\n" +"number songs :" + song1.size();
			//if (input.equals("Hi there!"))
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  ret;
	}
	
	public JSONObject loadAllSongs() throws RemoteServiceException{
		Resource r=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    this.songDao=factory.getBean(SongDaoImpl.class);
	    
	    ArrayList<Song> songs = this.songDao.getSongs();
	    //ArrayList<HashMap<String, String>> ret = new ArrayList<HashMap<String,String>>();
	    JSONArray listSongs = new JSONArray();
	    JSONObject ret = new JSONObject();
	    for(int index = 0; index < songs.size(); index++) {
	    	//HashMap<String, String> songInfo = new HashMap<String, String>();
	    	JSONObject songInfo = new JSONObject();
	    	Song song = songs.get(index);
	    	songInfo.put("id", String.valueOf(song.getId()));
	    	songInfo.put("name", song.getName());
	    	songInfo.put("author", song.getAuthor());
	    	listSongs.put( songInfo);
	    }
	    ret.put("songs",listSongs);
		return ret;
		
	}
	
	/*public HashMap<String, ArrayList<HashMap<String, String>>> loadAllSongs() throws RemoteServiceException{
		Resource r=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    this.songDao=factory.getBean(SongDaoImpl.class);
	    
	    ArrayList<Song> songs = this.songDao.getSongs();
	    //ArrayList<HashMap<String, String>> ret = new ArrayList<HashMap<String,String>>();
	    ArrayList<HashMap<String, String>> listSongs = new ArrayList<HashMap<String, String>>();
	    HashMap<String, ArrayList<HashMap<String, String>>> ret = new HashMap<String, ArrayList<HashMap<String, String>>>();
	    for(int index = 0; index < songs.size(); index++) {
	    	HashMap<String, String> songInfo = new HashMap<String, String>();
	    	//JSONObject songInfo = new JSONObject();
	    	Song song = songs.get(index);
	    	songInfo.put("id", String.valueOf(song.getId()));
	    	songInfo.put("name", song.getName());
	    	songInfo.put("author", song.getAuthor());
	    	listSongs.add(songInfo);
	    }
	    ret.put("songs",listSongs);
		return ret;
		
	}*/

	public SongDao getSongDao() {
		return songDao;
	}

	public void setSongDao(SongDao songDao) {
		this.songDao = songDao;
	}
}