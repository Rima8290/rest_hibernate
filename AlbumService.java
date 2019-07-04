package com.lti.hibernate;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.TransactionLog;

public class AlbumService  {

	public void enter(Album ab) {
		AlbumDao dao = new AlbumDao();
		dao.save(ab);
	}
	public List<Album> fetchSongs(int year){
		AlbumDao dao = new AlbumDao();
		List<Album> list=(List)dao.fetchAlbum(year);
		return list;
		 
	
}
	public List<Album> recentSongs(int id){
		AlbumDao dao = new AlbumDao();
		List<Album> list=(List)dao.fetchRecentSongs(id);
		return list;
		 
	}
}