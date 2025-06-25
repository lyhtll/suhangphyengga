package com.dgsw.suhangphyengga.diary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
public record DiaryRequest (
         String title,
         String content
){
}
