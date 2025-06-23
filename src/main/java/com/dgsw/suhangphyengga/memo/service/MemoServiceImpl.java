package com.dgsw.suhangphyengga.memo.service;

import com.dgsw.suhangphyengga.memo.dto.request.MemoRequest;
import com.dgsw.suhangphyengga.memo.dto.response.MemoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {

    @Override
    public List<MemoResponse> getAllMemo() {
        return List.of();
    }

    @Override
    public MemoResponse getMemo(Long id) {
        return null;
    }

    @Override
    public MemoResponse saveMemo(MemoRequest memoRequest) {
        return null;
    }

    @Override
    public void deleteMemo(Long id) {

    }

    @Override
    public MemoResponse updateMemo(Long id, MemoRequest memoRequest) {
        return null;
    }
}
