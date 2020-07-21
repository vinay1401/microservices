package springboot.jackson.example.model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import springboot.jackson.example.deserializer.DateDeserializer;
import springboot.jackson.example.serializer.DateSerializer;

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Customer {

	// By default Profile naming strategy is applied, you can override this by using
	// @JsonPropery Anotation
	// @JsonProperty(value = "CUSTOMER_ID")
	private UUID customerId;

	private String cutomerName;
	private String customerAddress;

	@JsonFormat(pattern = "dd-MMM-yyyy", shape = JsonFormat.Shape.STRING)
	private Date joinedDate;

	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date membershipExpiry;

	public Customer() {
	}

	public Customer(UUID customerId, String cutomerName, String customerAddress, Date joinedDate,
			Date membershipExpiry) {
		super();
		this.customerId = customerId;
		this.cutomerName = cutomerName;
		this.customerAddress = customerAddress;
		this.joinedDate = joinedDate;
		this.membershipExpiry = membershipExpiry;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public String getCutomerName() {
		return cutomerName;
	}

	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getMembershipExpiry() {
		return membershipExpiry;
	}

	public void setMembershipExpiry(Date membershipExpiry) {
		this.membershipExpiry = membershipExpiry;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cutomerName=" + cutomerName + ", customerAddress="
				+ customerAddress + ", joinedDate=" + joinedDate + ", membershipExpiry=" + membershipExpiry + "]";
	}
}
