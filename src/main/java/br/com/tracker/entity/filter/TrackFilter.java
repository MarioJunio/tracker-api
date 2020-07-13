package br.com.tracker.entity.filter;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TrackFilter implements Serializable {
	
	@NotNull
	private Integer userId;
	
	private Integer maxSpeed;

	private Double maxDistance;

	private Double maxAccuracy;

	private Integer maxTimer; 
}
