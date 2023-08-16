package com.metatest.backend.entrypoint.rest.model.output;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TestStrategyResponse {

    Long id;
    UUID externalUserId;
    String testStrategy;

}
