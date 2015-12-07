package co.edu.unal.mb.client.entity;

import co.edu.unal.mb.client.entity.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "frameendpoint", namespace = @ApiNamespace(ownerDomain = "edu.co", ownerName = "edu.co", packagePath = "unal.mb.client.entity") )
public class FrameEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listFrame")
	public CollectionResponse<Frame> listFrame(@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Frame> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Frame.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Frame>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Frame obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Frame> builder().setItems(execute).setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getFrame")
	public Frame getFrame(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Frame frame = null;
		try {
			frame = mgr.getObjectById(Frame.class, id);
		} finally {
			mgr.close();
		}
		return frame;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param frame the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertFrame")
	public Frame insertFrame(Frame frame) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsFrame(frame)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(frame);
		} finally {
			mgr.close();
		}
		return frame;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param frame the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateFrame")
	public Frame updateFrame(Frame frame) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsFrame(frame)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(frame);
		} finally {
			mgr.close();
		}
		return frame;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeFrame")
	public void removeFrame(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Frame frame = mgr.getObjectById(Frame.class, id);
			mgr.deletePersistent(frame);
		} finally {
			mgr.close();
		}
	}

	private boolean containsFrame(Frame frame) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Frame.class, frame.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
