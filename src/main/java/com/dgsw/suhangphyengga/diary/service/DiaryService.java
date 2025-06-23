package com.dgsw.suhangphyengga.diary.service;

import com.dgsw.suhangphyengga.diary.dto.request.DiaryRequest;
import com.dgsw.suhangphyengga.diary.dto.response.DiaryResponse;

import java.util.List;

public interface DiaryService {
    List<DiaryResponse> getAllDiary();
    DiaryResponse getDiary(Long id);
    DiaryResponse saveDiary(DiaryRequest diaryRequest);
    void deleteDiary(Long id);
    DiaryResponse updateDiary(Long id, DiaryRequest diaryRequest);
    List<DiaryResponse> getDiaryByTitle(String title);
}
