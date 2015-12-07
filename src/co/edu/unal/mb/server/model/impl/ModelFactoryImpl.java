package co.edu.unal.mb.server.model.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import co.edu.unal.mb.shared.model.IFrame;
import co.edu.unal.mb.shared.model.IModelFactory;
import co.edu.unal.mb.shared.model.IOrder;
import co.edu.unal.mb.shared.model.IProfile;

@Singleton
public class ModelFactoryImpl implements IModelFactory{

	@Inject
	public ModelFactoryImpl( final Provider<IFrame> frameProvider, final Provider<IOrder> orderProvider,
		final Provider<IProfile> profileProvider ) {
		super();
		this.frameProvider = frameProvider;
		this.orderProvider = orderProvider;
		this.profileProvider = profileProvider;
	}

	public IFrame createFrame(Long id, int frameprice, String description) {
		IFrame frame = frameProvider.get();
		frame.setId(id);
		frame.setFramePrice(frameprice);
		frame.setDescription(description);
		return frame;
	}
	
	public IOrder createOrder(Long id, int frameprice, int lensesprice) {
		IOrder order = orderProvider.get();
		order.setId(id);
		order.setFramePrice(frameprice);
		order.setLensesPrice(lensesprice);
		return order;
	}
	
	public IProfile createProfile(String username, String name, int id, String email, String contact, String password) {
		IProfile profile = profileProvider.get();
		profile.setUsername(username);
		profile.setName(name);
		profile.setId(id);
		profile.setEmail(email);
		profile.setContact(contact);
		profile.setPassword(password);
		return profile;
	}
	
	private final Provider<IFrame> frameProvider;
	private final Provider<IOrder> orderProvider;
	private final Provider<IProfile> profileProvider;

}
