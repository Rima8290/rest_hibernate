package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.service.AccountService;
import com.lti.service.AlbumService;

public class AlbumDaoTest {

	@Test
	public void createAlbum() {
		AlbumService as=new AlbumService();
		Album a=new Album();
		a.setId(123);
		a.setName("def");
		a.setCopyright("CopyDef");
		a.setYear(2012);
		as.createAlbum(a);
	}
	@Test
	public void insertSong() {
		AlbumService acServ=new AlbumService();
        acServ.insertSong(183);
	}
	
	
	@Test
	public void fetchSong() {
		
	         AlbumService alServ=new AlbumService();
	         List<Song> amt=alServ.getSongsByAlbum(183);
	         for(Song ac : amt)
	         {
	        	System.out.println(ac.getSinger());
	        	System.out.println(ac.getTitle());
	        	System.out.println(ac.getDuration());
	        
	         }
}
	
    
  
	

}
