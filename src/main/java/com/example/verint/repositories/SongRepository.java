package com.example.verint.repositories;

import com.example.verint.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findById(Long songId);

    @Query("select p.song from PlaylistSongs p where p.playlist.playlistId = :playlistId")
    List<Song> getPlaylistByPlaylistIdOrderByOrder(Long playlistId);
}
