package net.javaguideszain.banking.service.implementation;

import net.javaguideszain.banking.dto.AccountDto;
import net.javaguideszain.banking.entity.Account;
import net.javaguideszain.banking.mapper.AccountMapper;
import net.javaguideszain.banking.repository.AccountRepository;
import net.javaguideszain.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplmentation implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto findAccountById(Long id) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exist")
        );
        return AccountMapper.mapToAccountDto(existingAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(accountDto.getId()).orElseThrow(
                () -> new RuntimeException("Account does not exist")
        );

        existingAccount.setAccountNumber(accountDto.getAccountNumber());
        existingAccount.setAccountHolderName(accountDto.getAccountHolderName());
        //  existingAccount.setBalance(accountDto.getBalance());
        Account updatedAccount = accountRepository.save(existingAccount);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public AccountDto depositAmount(Long accId, double amount) {
        Account existingAccount = accountRepository.findById(accId).orElseThrow(
                () -> new RuntimeException("Account does not exist")
        );
        double totalAmount = existingAccount.getBalance() + amount;
        existingAccount.setBalance(totalAmount);
        Account savedAccount = accountRepository.save(existingAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account does not exist")
        );
        if (existingAccount.getBalance() > amount){
            double withdrawAmount = existingAccount.getBalance() - amount;
            existingAccount.setBalance(withdrawAmount);
        }else {
            throw new RuntimeException("You don't have insufficient balance to withdraw this amount");
        }
        Account updatedAccount =  accountRepository.save(existingAccount);
        return AccountMapper.mapToAccountDto(updatedAccount);

    }
}
