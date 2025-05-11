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
