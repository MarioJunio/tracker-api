package br.com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tracker.entity.Track;
import br.com.tracker.repository.custom.TrackRepositoryCustom;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long>, TrackRepositoryCustom {

}
