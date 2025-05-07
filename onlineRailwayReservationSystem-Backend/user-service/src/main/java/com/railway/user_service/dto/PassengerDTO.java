package com.railway.user_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private String mobileNumber;
    private String pnrNumber;
}
