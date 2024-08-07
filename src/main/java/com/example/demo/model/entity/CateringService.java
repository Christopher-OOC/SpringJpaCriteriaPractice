package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="catering_services")
public class CateringService {

	// cateringServiceId will be the same as customerId 
	@Id
	@Column(name="catering_service_id")
	private String cateringServiceId;
	
	private String businessName;
	
	// Tell customer why they should hire you
	private String businessVision;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Location location;
	
	@Column(name="logo_url")
	private String logoURL;
	
	private Date dateRegistered;
	
	@OneToOne(mappedBy="cateringService", fetch=FetchType.EAGER)
	private Customer customer;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private List<MediaPost> images = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private List<MediaPost> videos = new ArrayList<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CateringService other = (CateringService) obj;
		return Objects.equals(cateringServiceId, other.cateringServiceId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cateringServiceId);
	}
}
