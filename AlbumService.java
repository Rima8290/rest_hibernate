package com.lti.service;

import java.util.List;

import com.lti.dao.AlbumDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumService {
	AlbumDao dao=new AlbumDao();
	public void createAlbum(Album albumid) {
		dao.save(albumid);
		//Apart from this we might write/execute the code for sending email to the customer here
	}
	
	public void insertSong(int albumid) {
		Album ac=(Album) dao.fetchByPk(Album.class, albumid);
		Song s=new Song();
		    s.setTitle("Tom And Jerry");	
		    s.setSinger("Jassie Gill");
			s.setDuration(3.75);
			s.setAlbum(ac);
			dao.save(s);
		
	}
		//Apart from this we might write/execute the code for sending email to the customer here
	public List<Song> getSongsByAlbum(int albumid) {
		 
		List<Song> list = dao.fetchSongFromAlbum(albumid);
		return list;
	}
	}


