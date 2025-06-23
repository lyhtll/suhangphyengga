package com.dgsw.suhangphyengga.memo.service;

import com.dgsw.suhangphyengga.memo.dto.request.MemoRequest;
import com.dgsw.suhangphyengga.memo.dto.response.MemoResponse;
import com.dgsw.suhangphyengga.memo.entity.Memo;
import com.dgsw.suhangphyengga.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {
    private final MemoRepository memoRepository;

    @Override
    public List<MemoResponse> getAllMemo() {
        return memoRepository.findAll().stream().map(MemoResponse::of).toList();
    }

    @Override
    public MemoResponse getMemo(Long id) {
        Memo memo = getMemoById(id);
        return MemoResponse.of(memo);
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

    private Memo getMemoById(Long id){
        return memoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found memo"));
    }
}
