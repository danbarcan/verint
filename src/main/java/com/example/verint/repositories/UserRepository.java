package com.example.verint.repositories;

import com.example.verint.entities.Song;
import com.example.verint.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);

    Optional<User> findByUserName(String userName);

    @Query("select s.user from SongsPlaying s where s.song.songId = :songId")
    List<User> getUsersPlayingSong(Long songId);

    @Query("select count(s.user) from SongsPlaying s where s.song.songId = :songId")
    Long getNoUsersPlayingSong(Long songId);
}
