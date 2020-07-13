package br.com.tracker.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "track")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Track implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private int speed;

	private double distance;

	private double accuracy;

	private int timer;

	@OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
	private List<Coordinate> coordinates = new ArrayList<>();

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "launch_id")
	private Launch launch;
	
	@Version
	private int version;

}
