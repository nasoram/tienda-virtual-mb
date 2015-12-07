package co.edu.unal.mb.service.ofy;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import co.edu.unal.mb.client.entity.Frame;
import co.edu.unal.mb.server.model.impl.ofy.OfyFrame;
import co.edu.unal.mb.server.model.impl.ofy.OfyOrder;
import co.edu.unal.mb.server.model.impl.ofy.OfyProfile;

/**
 * Custom Objectify Service that this application should use.
 */
public class OfyService {
    /**
     * This static block ensure the entity registration.
     */
    static {
//        factory().register(Order.class);
//        factory().register(Profile.class);
        factory().register(Frame.class);
    }

    /**
     * Use this static method for getting the Objectify service object in order to make sure the
     * above static block is executed before using Objectify.
     * @return Objectify service object.
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Use this static method for getting the Objectify service factory.
     * @return ObjectifyFactory.
     */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
