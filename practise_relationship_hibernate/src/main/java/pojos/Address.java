package pojos;
import javax.persistence.*;
@Entity
@Table(name = "address")
public class Address extends BaseEntity {
@Column(length = 30)
private String city;
@Column(length = 10)
private String country;
@Column(name = "zip_code",length=30)
private String zipCode;
@Column(length = 10,unique = true,name="phone_no")
private String phoneNo;
//one to one uni dir association between entities
@OneToOne    //mandatory
@JoinColumn(name = "student_id")
@MapsId  //to tell hibernate : "student_id" column will be FK that references PK of Student_tbl n will share the values from the same (shared PK)
private Student owner;

public Address()
{
	System.out.println("in Constructor of "+getClass().getName());
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public Student getOwner() {
	return owner;
}

public void setOwner(Student owner) {
	this.owner = owner;
}


}
