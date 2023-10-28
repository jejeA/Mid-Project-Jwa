package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Entity.AccountStatus;
import com.example.demo.Jwa.Bank.System.Repository.AccountRepository;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountHolderServiceImp;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 @SpringBootTest
    class AccountControllerTest {

        @Autowired
        private WebApplicationContext webApplicationContext;
        private MockMvc mockMvc;
        private final ObjectMapper objectMapper=new ObjectMapper();

        @MockBean
        private AccountServiceImp accountServiceImp;


        @BeforeEach
        public void setup() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }

//        @Test
//        void getAllAccountTest()throws Exception {
//            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
//                    .andExpect(status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                    .andReturn();
//            assertTrue(mvcResult.getResponse().getContentAsString().contains("9000.0"));
//            assertTrue(mvcResult.getResponse().getContentAsString().contains("10000.0"));
//
//        }
//     @Test
//     public void getAllAccountTest() throws Exception {
//         Account account = new Account();
//         account.setBalance(10000.0);
//
//         when(accountServiceImp.getAllAccount(8890)).thenReturn(account);
//
//         mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(10000.0));
//
//     }
@Test
void getAllAccountTest() throws Exception {
    // Mock data to return when the service is called
    List<Account> accounts = Arrays.asList(
            new Account("Business" ,1290, 10000.0, AccountStatus.CheckingAccount),
            new Account("Business" ,6773, 9000.0, AccountStatus.SavingAccount)
    );
    // Mock the service to return the mock data
    when(accountServiceImp.getAllAccount()).thenReturn(accounts);
    MvcResult mvcResult = mockMvc.perform(get("/accounts"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    String responseContent = mvcResult.getResponse().getContentAsString();

    // Assert that the response content contains the account details
    assertTrue(responseContent.contains("Business"));
    assertTrue(responseContent.contains("Business"));
    assertTrue(responseContent.contains("10000.0"));
    assertTrue(responseContent.contains("9000.0"));

}

     @Test
     void addAccountTest() throws Exception {
         // Mock account data for the request
         Account accountToAdd = new Account("Vacation", 187348, 69900.0, AccountStatus.SavingAccount);
         // Mock the service to handle the account addition
         when(accountServiceImp.addAccount(accountToAdd)).thenReturn(accountToAdd);

         MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/add/account")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content("{\"id\":1,\"name\":\"Vacation\",\"accountNumber\":187348,\"balance\":69900.0,\"accountStatus\":\"SavingAccount\"}"))
                 .andExpect(status().isCreated())
                 .andExpect(content().string("Account added successfully"))
                 .andReturn();
     }


     @Test
     void depositTest() throws Exception {
         // Mock data for the request
         int accountNumber = 187348;
         double amount = 1000.0;

         // Mock the service to handle the deposit
         String message = "Deposit successful";
         when(accountServiceImp.deposit(accountNumber, amount)).thenReturn(message);
         MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/deposit/{accountNumber}", accountNumber)
                         .param("amount", String.valueOf(amount))
                         .contentType(MediaType.APPLICATION_JSON) )
                 .andExpect(status().isOk())
                 .andExpect(content().string("Deposit successful"))
                 .andReturn();
     }

     @Test
     void testShowBalance() throws Exception {
         int accountNumber = 1290;
         String balanceMessage = "Your balance is $10000.00";

         when(accountServiceImp.showBalance(accountNumber)).thenReturn(balanceMessage);

         mockMvc.perform(get("/balance/{accountNumber}", accountNumber)
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(content().string(balanceMessage));
     }




 }















