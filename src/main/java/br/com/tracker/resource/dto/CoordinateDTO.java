package br.com.tracker.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateDTO {
	
	private Long id;
	private double latitude;
	private double longitude;
	private TrackDTO track;
}
