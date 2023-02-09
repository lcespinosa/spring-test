package com.meh.psyco.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private String cdid;

    private String name;

    private String lastName;

    private String address;

    private String phone;

    private String email;
}
