public class Contract {
	private String address;
	private String name;
	private String compiler;
	private String balance;
	private String txCount;
	private String settings;
	private String dateTime;
	private String code;

	public Contract() {
		super();
	}

	public Contract(String address, String name, String compiler, String balance, String txCount, String settings,
			String dateTime) {
		super();
		this.address = address;
		this.name = name;
		this.compiler = compiler;
		this.balance = balance;
		this.txCount = txCount;
		this.settings = settings;
		this.dateTime = dateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompiler() {
		return compiler;
	}

	public void setCompiler(String compiler) {
		this.compiler = compiler;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTxCount() {
		return txCount;
	}

	public void setTxCount(String txCount) {
		this.txCount = txCount;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return "Contract [address=" + address + ", name=" + name + ", compiler=" + compiler + ", balance=" + balance
				+ ", txCount=" + txCount + ", settings=" + settings + ", dateTime=" + dateTime + "]";
	}

}
