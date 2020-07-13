package br.com.tracker.resource.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TrackDTO {

	@EqualsAndHashCode.Include
	private Long id;

	private int speed;

	private double distance;

	private double accuracy;

	private int timer;

	@JsonIgnoreProperties(value = { "track" })
	private List<CoordinateDTO> coordinates = new ArrayList<>();

	private LaunchDTO launch;
}
