package com.springboot.auth.authentication.entity;

import com.springboot.cloud.core.entity.Entity;
import lombok.*;

@Data
@NoArgsConstructor
public class Resource extends Entity {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
