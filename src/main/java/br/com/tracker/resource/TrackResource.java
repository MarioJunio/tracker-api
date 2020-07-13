package br.com.tracker.resource;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tracker.entity.Track;
import br.com.tracker.entity.filter.TrackFilter;
import br.com.tracker.resource.dto.TrackDTO;
import br.com.tracker.service.TrackService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tracks")
public class TrackResource {

	private TrackService trackService;
	private ModelMapper modelMapper;

	@Autowired
	public TrackResource(TrackService trackService, ModelMapper modelMapper) {
		this.trackService = trackService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<TrackDTO> salvar(@RequestBody TrackDTO trackDTO) {
		Track trackSaved = trackService.salvar(modelMapper.map(trackDTO, Track.class));

		return ResponseEntity.created(null).body(modelMapper.map(trackSaved, TrackDTO.class));
	}

	@GetMapping
	public ResponseEntity<List<TrackDTO>> listAll(@Valid TrackFilter filter) {
		log.info("listAll > filter: {}", filter);

		List<Track> tracks = trackService.searchAll(filter);

		Type listType = new TypeToken<List<TrackDTO>>() {
		}.getType();

		return ResponseEntity.ok(modelMapper.map(tracks, listType));
	}
	
	@DeleteMapping("/{trackId}")
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable Long trackId) {
		trackService.delete(trackId);
	}
}
