package net.javaguideszain.banking.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private double balance;

}

/*They are special kind of class which is used as DTO and this helps us to achieve the encapsulation and it is immutable by nature*/
//public record AccountDto(Long id, String accountNumber, String accountHolderName,double balance ){}