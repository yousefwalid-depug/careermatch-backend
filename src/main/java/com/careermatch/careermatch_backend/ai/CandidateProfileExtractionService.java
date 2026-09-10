package com.careermatch.careermatch_backend.ai;

import com.careermatch.careermatch_backend.entity.DomainEnums.Confidence;
import java.util.*;

public interface CandidateProfileExtractionService {
    ExtractedProfile extract(String cvText, Collection<String> knownSkillTerms);
    record ExtractedProfile(int totalExperienceMonths, Confidence confidence, Set<String> detectedSkillTerms) {}
}
