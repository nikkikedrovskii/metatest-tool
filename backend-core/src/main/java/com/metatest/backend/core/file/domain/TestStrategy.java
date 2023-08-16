package com.metatest.backend.core.file.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestStrategy {

    String id;
    String description;
    String conditions;
    String steps;
    String output;

}
