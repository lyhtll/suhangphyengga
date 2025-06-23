package com.dgsw.suhangphyengga.memo.dto.response;

import com.dgsw.suhangphyengga.memo.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoResponse {
    private Long id;
    private String title;
    private String content;

    public static MemoResponse of(Memo memo) {
        return MemoResponse.builder()
                .id(memo.getMemoId())
                .title(memo.getTitle())
                .content(memo.getContent())
                .build();
    }
}
