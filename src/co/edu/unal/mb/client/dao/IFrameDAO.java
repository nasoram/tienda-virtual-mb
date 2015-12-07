package co.edu.unal.mb.client.dao;

import java.util.List;

import co.edu.unal.mb.shared.model.IFrame;

public interface IFrameDAO {
	
	void save( IFrame frame );
	
	IFrame fetchById( long id );
	
	List<IFrame> fetchAllFrames();
	
	boolean isEmpty();
	
}
