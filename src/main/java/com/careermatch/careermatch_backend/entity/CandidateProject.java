package com.careermatch.careermatch_backend.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "candidate_projects")
public class CandidateProject {
    @Id private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "profile_id") private CandidateProfile profile;
    @Column(nullable = false) private String title;
    @Column(columnDefinition = "text") private String description;
    protected CandidateProject() {}
    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
