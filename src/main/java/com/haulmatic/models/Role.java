package com.haulmatic.models;

import com.haulmatic.utils.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "role")
public class Role {

    @Id
    private String id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String roleType;

}
