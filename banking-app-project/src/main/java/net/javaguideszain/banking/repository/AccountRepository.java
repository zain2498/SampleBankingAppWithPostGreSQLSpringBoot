package net.javaguideszain.banking.repository;

import net.javaguideszain.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
