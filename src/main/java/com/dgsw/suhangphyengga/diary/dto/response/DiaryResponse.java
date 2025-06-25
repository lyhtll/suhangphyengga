package com.dgsw.suhangphyengga.diary.dto.response;

import com.dgsw.suhangphyengga.diary.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record DiaryResponse(
          Long id,
         String title,
         String content
) {
    public static DiaryResponse of(Diary diary) {
        return DiaryResponse.builder()
                .id(diary.getDiaryId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .build();
    }
}
