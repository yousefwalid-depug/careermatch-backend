package com.careermatch.careermatch_backend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "candidate_education")
public class CandidateEducation {
    @Id private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "profile_id") private CandidateProfile profile;
    private String degree;
    @Column(name = "field_of_study") private String fieldOfStudy;
    private String institution;
    @Column(name = "education_level") private String educationLevel;
    protected CandidateEducation() {}
    public UUID getId() { return id; }
    public String getDegree() { return degree; }
    public String getFieldOfStudy() { return fieldOfStudy; }
    public String getInstitution() { return institution; }
    public String getEducationLevel() { return educationLevel; }
}
