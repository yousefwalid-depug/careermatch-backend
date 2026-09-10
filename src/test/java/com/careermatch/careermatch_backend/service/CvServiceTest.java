package com.careermatch.careermatch_backend.service;

import com.careermatch.careermatch_backend.ai.CandidateProfileExtractionService;
import com.careermatch.careermatch_backend.exception.InvalidCvException;
import com.careermatch.careermatch_backend.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockMultipartFile;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CvServiceTest {
    @Test void rejectsNonPdfUpload() {
        CvService service = new CvService("target/test-uploads", mock(UserRepository.class), mock(CvRepository.class),
                mock(CandidateProfileRepository.class), mock(SkillRepository.class), mock(SkillAliasRepository.class),
                mock(CandidateProfileSkillRepository.class), mock(CandidateProfileExtractionService.class));
        MockMultipartFile file = new MockMultipartFile("file", "resume.txt", "text/plain", "hello".getBytes());
        InvalidCvException error = assertThrows(InvalidCvException.class, () -> service.upload(file));
        assertEquals("Only PDF uploads are supported", error.getMessage());
    }
}
