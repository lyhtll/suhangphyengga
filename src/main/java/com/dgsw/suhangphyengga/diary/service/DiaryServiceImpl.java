package com.dgsw.suhangphyengga.diary.service;

import com.dgsw.suhangphyengga.diary.dto.request.DiaryRequest;
import com.dgsw.suhangphyengga.diary.dto.response.DiaryResponse;
import com.dgsw.suhangphyengga.diary.entity.Diary;
import com.dgsw.suhangphyengga.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository;

    @Override
    public List<DiaryResponse> getAllDiary() {
        return diaryRepository.findAll().stream().map(DiaryResponse::of).toList();
    }

    @Override
    public DiaryResponse getDiary(Long id) {
        Diary diary = getDiaryById(id);
        return DiaryResponse.of(diary);
    }

    @Override
    public DiaryResponse saveDiary(DiaryRequest diaryRequest) {
        Diary createdDiary = Diary.builder()
                .title(diaryRequest.getTitle())
                .content(diaryRequest.getContent())
                .build();
        return DiaryResponse.of(diaryRepository.save(createdDiary));
    }

    @Override
    public void deleteDiary(Long id) {
        Diary deletedDiary = getDiaryById(id);
        diaryRepository.delete(deletedDiary);
    }

    @Override
    public DiaryResponse updateDiary(Long id, DiaryRequest diaryRequest) {
        Diary diary = getDiaryById(id);
        updateDiary(diary, diaryRequest);
        return DiaryResponse.of(diaryRepository.save(diary));
    }

    @Override
    public List<DiaryResponse> getDiaryByTitle(String title) {
        return diaryRepository.findByTitleContaining(title).stream().map(DiaryResponse::of).toList();
    }

    private void updateDiary(Diary diary, DiaryRequest request) {
        if (request.getTitle() != null) diary.setTitle(request.getTitle());
        if (request.getContent() != null) diary.setContent(request.getContent());
    }

    private Diary getDiaryById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found diary"));
    }
}
