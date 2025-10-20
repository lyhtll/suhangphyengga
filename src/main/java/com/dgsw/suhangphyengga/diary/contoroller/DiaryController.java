package com.dgsw.suhangphyengga.diary.contoroller;

import com.dgsw.suhangphyengga.diary.dto.request.DiaryRequest;
import com.dgsw.suhangphyengga.diary.dto.response.DiaryResponse;
import com.dgsw.suhangphyengga.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 헬로
@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @GetMapping
    public ResponseEntity<List<DiaryResponse>> getAllDiarys() {
        return ResponseEntity.ok(diaryService.getAllDiary());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiaryResponse> getDiaryById(
            @PathVariable Long id) {
        return ResponseEntity.ok(diaryService.getDiary(id));
    }

    @PostMapping
    public ResponseEntity<DiaryResponse> createDiary(@RequestBody DiaryRequest diaryRequest) {
        return new ResponseEntity<>(diaryService.saveDiary(diaryRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaryById(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiaryResponse> updateDiaryById(@PathVariable Long id,@RequestBody DiaryRequest diaryRequest) {
        return new ResponseEntity<>(diaryService.updateDiary(id,diaryRequest),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DiaryResponse>> getDiaryByTitle(@RequestParam String title) {
        return ResponseEntity.ok(diaryService.getDiaryByTitle(title));
    }

}
