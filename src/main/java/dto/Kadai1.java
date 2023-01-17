package dto;

public class Kadai1 {
	private String name;
	private String age;
	private String gne;
	private String pn;
	private String mail;
	private String salt;
	private String password;
	private String hasedPass;
	
	public Kadai1(String name,String age,String gne,String pn,String mail,String salt,String password,String hasedPass) {
		super();
		this.name=name;
		this.age=age;
		this.gne=gne;
		this.pn=pn;
		this.mail=mail;
		this.salt=salt;
		this.password=password;
		this.hasedPass=hasedPass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGne() {
		return gne;
	}

	public void setGne(String gne) {
		this.gne = gne;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHasedPass() {
		return hasedPass;
	}

	public void setHasedPass(String hasedPass) {
		this.hasedPass = hasedPass;
	}
	
}
