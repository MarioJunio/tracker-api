package br.com.tracker.resource.dto;

import br.com.tracker.entity.LaunchType;
import br.com.tracker.entity.LaunchUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaunchDTO {
	
	private Long id;
	private LaunchType type;
	private LaunchUnitType unitType;
	private int value;
}
