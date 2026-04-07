package org.cognizant.auditcompliancemanagement.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String status;
}