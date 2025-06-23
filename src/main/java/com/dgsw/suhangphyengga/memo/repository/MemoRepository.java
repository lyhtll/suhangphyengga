package com.dgsw.suhangphyengga.memo.repository;

import com.dgsw.suhangphyengga.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByTitleContaining(String title);
}
