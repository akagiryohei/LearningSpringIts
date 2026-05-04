package com.example.its.domein.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IssueEntity {
    private long id;
    private String summary;
    private String description;
}
