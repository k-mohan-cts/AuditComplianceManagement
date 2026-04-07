package org.cognizant.auditcompliancemanagement.child;

import org.cognizant.auditcompliancemanagement.dto.request.UserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USERCITIZENMANAGEMENT")
public interface UserInterface {

    @GetMapping("/api/users/fetchUserStatus/{id}")
    String FetchUserStatusById(@PathVariable("id") int id);

    @GetMapping("/api/users/getByUserId/{id}")
    UserRequestDTO FetchUserById(@PathVariable("id") int id);
}