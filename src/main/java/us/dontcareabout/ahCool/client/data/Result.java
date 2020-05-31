package us.dontcareabout.ahCool.client.data;

public class Result {
	public final BasicData basic;
	public final InputData input;

	public Result(BasicData basic, InputData input) {
		this.basic = basic;
		this.input = input;
	}

	public double getRealPrice() {
		return 1.0 * basic.getAgreeArea() * basic.getAgreePrice() * input.getNumerator() / input.getDenominator();
	}

	public String getArea() {
		return basic.getArea();
	}

	public String getSection() {
		return basic.getSection();
	}

	public String getBlock() {
		return basic.getBlock();
	}

	public String getNumber() {
		return basic.getNumber();
	}

	public String getType() {
		return basic.getType();
	}

	public String getUseType() {
		return basic.getUseType();
	}

	public String getRefactorFarm() {
		return basic.getRefactorFarm();
	}

	public int getOriginArea() {
		return basic.getOriginArea();
	}

	public int getAgreeArea() {
		return basic.getAgreeArea();
	}

	public int getAgreePrice() {
		return basic.getAgreePrice();
	}

	public int getDeclarePrice() {
		return basic.getDeclarePrice();
	}

	public String getNote() {
		return basic.getNote();
	}

	public String getComment() {
		return basic.getComment();
	}

	public int getNumerator() {
		return input.getNumerator();
	}

	public int getDenominator() {
		return input.getDenominator();
	}
}
