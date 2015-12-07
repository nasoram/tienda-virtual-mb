package co.edu.unal.mb.shared;

import com.google.gwt.user.client.ui.RadioButton;

public class StringHelper {
	
	public static String assembleProfile(
			String username,
			String name,
			String id,
			String email,
			String contact,
			String password) {
		return "NOMBRE DE USUARIO: " + username +
				"\nNOMBRE: " + name +
				"\nIDENTIFICACION: " + id +
				"\nCORREO: " + email != null ? email : "NULL" +
				"\nCONTACTO: " + contact != null ? contact : "NULL" +
				"\nCONTRASENA: " + password != null ? password : "NULL";
	}
	
	public static String assembleOrder(
			String name,
			String orderid,
			String frame,
			int lensesprice) {
		return "NOMBRE DE CLIENTE: " + name +
				"\nNO. RECIBO: " + orderid +
				"\nPRECIO MONTURA: " + getDummyFramePrice(frame) +
				"\nPRECIO LENTES: " + lensesprice +
				"\nPRECIO TOTAL: " +
				(getDummyFramePrice(frame) + lensesprice);
	}
	
	public static int getDummyFramePrice(String dummyframe) {
		int price = 0;
		if(dummyframe == "RayBan") price = 120000;
		if(dummyframe == "Police") price = 130000;
		if(dummyframe == "Ginebra") price = 100000;
		if(dummyframe == "Gabbiana") price = 90000;
		if(dummyframe == "Fazio") price = 90000;
		if(dummyframe == "Miraflex") price = 60000;
		return price;
	}
	
	public static String toHtml(String nohtml){
		return nohtml.replaceAll("\n", "<BR>");
	}

}
