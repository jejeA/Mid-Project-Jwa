package com.example.demo.Jwa.Bank.System.Services.Implementation;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Repository.AccountHolderRepository;
import com.example.demo.Jwa.Bank.System.Services.Interface.AccountHolderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderServiceImp implements AccountHolderInterface {

    @Autowired
    private AccountHolderRepository accountHolderRepository;




    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public String updateAccountHolder(int id, AccountHolder accountHolder) {
        if (accountHolderRepository.existsById(id)) {
            accountHolder.setIdUser(id); // Ensure the ID is set for the update
            accountHolderRepository.save(accountHolder);
            return "account updated Successfully";

        }
        return "account not updated Successfully";

    }

    @Override
    public String deleteAccountHolder(int id) {
        accountHolderRepository.deleteById(id);
        return "account deleted Successfully";
    //        }else return "account not found";
    }


    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderRepository.findAll();
    }

    @Override
    public Optional<AccountHolder> findByAccountHoldertId(int id) {
        return accountHolderRepository.findById(id);
    }
}
