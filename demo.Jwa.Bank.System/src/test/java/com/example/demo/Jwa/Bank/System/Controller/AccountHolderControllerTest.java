//package com.example.demo.Jwa.Bank.System.Controller;
//
//import com.example.demo.Jwa.Bank.System.Entity.Account;
//import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
//import com.example.demo.Jwa.Bank.System.Entity.AccountStatus;
//import com.example.demo.Jwa.Bank.System.Repository.AccountHolderRepository;
//import com.example.demo.Jwa.Bank.System.Repository.AccountRepository;
//import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountHolderServiceImp;
//import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static com.example.demo.Jwa.Bank.System.Entity.AccountStatus.SavingAccount;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//class AccountHolderControllerTest {
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//    private MockMvc mockMvc;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @MockBean
//    private AccountServiceImp accountServiceImp;
//
//    @MockBean
//    private Account account;
//
//
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//
//    @Test
//    void testGetAllAccountHolders() throws Exception {
//        List<AccountHolder> accountHolders = Arrays.asList(
//                new AccountHolder(1009,"Abha","Manar@gmail.com","Manar","Ma1234",new Account("Business",7589,6000.0,account.setAccountStatus(SavingAccount))),
//        new AccountHolder(1324,"Riyadh","ad.jwa@gmail.com","Jawaher","Ad09098",6773,new Account("Business",6773,9000,account.getAccountStatus()) ;
//        when(accountHolderServiceImp.getAllAccountHolders()).thenReturn(accountHolders);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/alltables")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//    }}