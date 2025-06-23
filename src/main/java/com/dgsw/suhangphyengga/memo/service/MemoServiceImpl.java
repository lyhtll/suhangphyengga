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
        Memo createdMemo = Memo.builder()
                .title(memoRequest.getTitle())
                .content(memoRequest.getContent())
                .build();
        return MemoResponse.of(memoRepository.save(createdMemo));
    }

    @Override
    public void deleteMemo(Long id) {
        Memo deletedMemo = getMemoById(id);
        memoRepository.delete(deletedMemo);
    }

    @Override
    public MemoResponse updateMemo(Long id, MemoRequest memoRequest) {
        Memo memo = getMemoById(id);
        updateProduct(memo, memoRequest);
        return MemoResponse.of(memoRepository.save(memo));
    }

    @Override
    public List<MemoResponse> getMemoByTitle(String title) {
        return memoRepository.findByTitleContaining(title).stream().map(MemoResponse::of).toList();
    }

    private void updateProduct(Memo memo, MemoRequest request) {
        if (request.getTitle() != null) memo.setTitle(request.getTitle());
        if (request.getContent() != null) memo.setContent(request.getContent());
    }

    private Memo getMemoById(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found memo"));
    }
}
