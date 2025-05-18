package org.writer.webadmin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpecDto {
    private Long id;
    private String name;
    private String value;
}
