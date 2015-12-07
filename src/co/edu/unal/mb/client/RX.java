package co.edu.unal.mb.client;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.RadioButton;

public class RX {
	
	private boolean farview;
	private boolean closeview;
	private boolean bifocal;
	private boolean progressive;
	private boolean polycarbonate;
	private boolean uv;
	private boolean ar;
	private boolean trivex;
	private boolean futurex;
	private boolean transitions;
	
	public RX(boolean farview, boolean closeview, boolean bifocal, boolean progressive, boolean polycarbonate,
			boolean uv, boolean ar, boolean trivex, boolean futurex, boolean transitions) {
		super();
		this.farview = farview;
		this.closeview = closeview;
		this.bifocal = bifocal;
		this.progressive = progressive;
		this.polycarbonate = polycarbonate;
		this.uv = uv;
		this.ar = ar;
		this.trivex = trivex;
		this.futurex = futurex;
		this.transitions = transitions;
	}
	
	public RX(RadioButton farview, RadioButton closeview, RadioButton bifocal, RadioButton progressive, CheckBox polycarbonate,
			RadioButton uv, RadioButton ar, CheckBox trivex, RadioButton futurex, RadioButton transitions) {
		super();
		this.farview = (farview.isEnabled() && farview.getValue());
		this.closeview = (closeview.isEnabled() && closeview.getValue());
		this.bifocal = (bifocal.isEnabled() && bifocal.getValue());
		this.progressive = (progressive.isEnabled() && progressive.getValue());
		this.polycarbonate = polycarbonate.getValue();
		this.uv = uv.getValue();
		this.ar = ar.getValue();
		this.trivex = trivex.getValue();
		this.futurex = futurex.getValue();
		this.transitions = transitions.getValue();
	}

	public boolean isFarview() {
		return farview;
	}

	public void setFarview(boolean farview) {
		this.farview = farview;
	}

	public boolean isCloseview() {
		return closeview;
	}

	public void setCloseview(boolean closeview) {
		this.closeview = closeview;
	}

	public boolean isBifocal() {
		return bifocal;
	}

	public void setBifocal(boolean bifocal) {
		this.bifocal = bifocal;
	}

	public boolean isProgressive() {
		return progressive;
	}

	public void setProgressive(boolean progressive) {
		this.progressive = progressive;
	}

	public boolean isPolycarbonate() {
		return polycarbonate;
	}

	public void setPolycarbonate(boolean polycarbonate) {
		this.polycarbonate = polycarbonate;
	}

	public boolean isUv() {
		return uv;
	}

	public void setUv(boolean uv) {
		this.uv = uv;
	}

	public boolean isAr() {
		return ar;
	}

	public void setAr(boolean ar) {
		this.ar = ar;
	}

	public boolean isTrivex() {
		return trivex;
	}

	public void setTrivex(boolean trivex) {
		this.trivex = trivex;
	}

	public boolean isFuturex() {
		return futurex;
	}

	public void setFuturex(boolean futurex) {
		this.futurex = futurex;
	}

	public boolean isTransitions() {
		return transitions;
	}

	public void setTransitions(boolean transitions) {
		this.transitions = transitions;
	}
	
	public int calculateLensesPrice() {
		int price = 0;
		if (this.farview) price += 30000;
		if (this.closeview) price += 60000;
		if (this.bifocal) price += 50000;
		if (this.progressive) price += 120000;
		if (this.polycarbonate) price += 50000;
		if (this.uv) price += 10000;
		if (this.ar) price += 50000;
		if (this.trivex) price += 80000;
		if (this.futurex) price += 110000;
		if (this.transitions) price += 50000;
		return price;
	}
	
}
