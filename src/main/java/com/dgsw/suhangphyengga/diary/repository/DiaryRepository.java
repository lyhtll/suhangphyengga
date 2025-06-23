package com.dgsw.suhangphyengga.diary.repository;

import com.dgsw.suhangphyengga.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByTitleContaining(String title);
}
