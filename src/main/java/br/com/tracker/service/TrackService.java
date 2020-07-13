package br.com.tracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tracker.entity.Track;
import br.com.tracker.entity.filter.TrackFilter;
import br.com.tracker.repository.TrackRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TrackService {

	private TrackRepository trackRepository;

	@Autowired
	public TrackService(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	public Track salvar(Track track) {
		track.getCoordinates().forEach(coord -> coord.setTrack(track));
		
		log.info("Track: {}", track);

		return trackRepository.save(track);
	}
	
	public List<Track> searchAll(TrackFilter filter) {
		return trackRepository.findAll();
	}
	
	
	public void delete(Long trackId) {
		trackRepository.deleteById(trackId);
	}
}
