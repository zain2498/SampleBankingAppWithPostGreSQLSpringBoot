package net.javaguideszain.banking.controller;

import net.javaguideszain.banking.dto.AccountDto;
import net.javaguideszain.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/openaccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto savedAcc = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAcc, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.findAccountById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountDto> updateAccountInfo(@PathVariable("id") Long accountId,
                                                        @RequestBody AccountDto accountDto){
        accountDto.setId(accountId);
        return ResponseEntity.ok(accountService.updateAccount(accountDto));
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable("id") Long accId,
                                                   @RequestBody Map<String, Double> req){
        double amount = req.get("amount");
         return ResponseEntity.ok(accountService.depositAmount(accId,amount));
    }

    @PutMapping("withdraw/{id}")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id,
                                                     @RequestBody Map<String, Double> request){
        double withdrawlAmount = request.get("amount");
        return ResponseEntity.ok(accountService.withdrawAmount(id, withdrawlAmount));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Your account is successfully deleted");
    }
}
