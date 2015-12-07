package co.edu.unal.mb.shared.model;

public interface IModelFactory {
	
	IFrame createFrame(Long id, int frameprice, String description);
	
	IOrder createOrder(Long id, int frameprice, int lensesprice);
	
	IProfile createProfile(String username, String name, int id, String email, String contact, String password);

}
