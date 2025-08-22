package com.learning.SpringBootEcom.Model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	
	@JsonFormat(shape = Shape.STRING, pattern="dd-MM-yyyy")
	private Date releaseDate;
	private boolean prodcutAvailable;
	private int stockQuantity;
	
	//fields to accepts images
	private String imageName;
	private String imageType;
	
	@Lob //to convert image into large binary object
	private byte[] imageData;
	
	
}
