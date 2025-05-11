package net.javaguideszain.banking.service;

import net.javaguideszain.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto findAccountById(Long id);
    List<AccountDto> getAllAccounts();

    AccountDto updateAccount(AccountDto accountDto);

    AccountDto depositAmount(Long accId, double amount);

    AccountDto withdrawAmount (Long id, double amount);

    void deleteAccount(long id);
}
