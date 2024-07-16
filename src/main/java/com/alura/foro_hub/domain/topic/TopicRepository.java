package com.alura.foro_hub.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    Optional<Topic> findByTitleAndMessage(String title, String message);

    Page<Topic> findByCourseName(String courseName, Pageable pageable);
}
