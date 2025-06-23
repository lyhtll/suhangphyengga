package com.dgsw.suhangphyengga.memo.service;

import com.dgsw.suhangphyengga.memo.dto.request.MemoRequest;
import com.dgsw.suhangphyengga.memo.dto.response.MemoResponse;

import java.util.List;

public interface MemoService {
    List<MemoResponse> getAllMemo();
    MemoResponse getMemo(Long id);
    MemoResponse saveMemo(MemoRequest memoRequest);
    void deleteMemo(Long id);
    MemoResponse updateMemo(Long id,MemoRequest memoRequest);
    List<MemoResponse> getMemoByTitle(String title);
}
