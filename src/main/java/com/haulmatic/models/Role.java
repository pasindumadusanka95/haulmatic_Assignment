package com.haulmatic.models;

import com.haulmatic.utils.RoleType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {

    @Id
    private String id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private RoleType roleType;

    public String getId() { return id; }

    public void setIf(String id) { this.id = id; }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) { this.organization = organization; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName;}

    public String getNicNo() { return nicNo; }

    public void setNicNo(String nicNo) { this.nicNo = nicNo; }

    public RoleType getRoleType() { return roleType; }

    public void setRoleType(RoleType roleType) { this.roleType = roleType; }


}
