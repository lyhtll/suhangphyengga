package com.dgsw.suhangphyengga.memo.repository;

import com.dgsw.suhangphyengga.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
