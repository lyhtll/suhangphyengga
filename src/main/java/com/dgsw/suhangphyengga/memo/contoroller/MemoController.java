package com.dgsw.suhangphyengga.memo.contoroller;

import com.dgsw.suhangphyengga.memo.dto.request.MemoRequest;
import com.dgsw.suhangphyengga.memo.dto.response.MemoResponse;
import com.dgsw.suhangphyengga.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memo")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping
    public ResponseEntity<List<MemoResponse>> getAllMemos() {
        return ResponseEntity.ok(memoService.getAllMemo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemoResponse> getMemoById(
            @PathVariable Long id) {
        return ResponseEntity.ok(memoService.getMemo(id));
    }

    @PostMapping
    public ResponseEntity<MemoResponse> createMemo(@RequestBody MemoRequest memoRequest) {
        return new ResponseEntity<>(memoService.saveMemo(memoRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemoById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponse> updateMemoById(@PathVariable Long id,@RequestBody MemoRequest memoRequest) {
        return new ResponseEntity<>(memoService.updateMemo(id,memoRequest),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MemoResponse>> getMemoByTitle(@RequestParam String title) {
        return ResponseEntity.ok(memoService.getMemoByTitle(title));
    }

}
