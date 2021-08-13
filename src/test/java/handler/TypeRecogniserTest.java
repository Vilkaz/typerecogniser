package handler;


import com.serverless.handler.TypeRecogniser;
import com.serverless.model.InputType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TypeRecogniserTest {


    @Test
    void recogniseClient() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        InputType type = typeRecogniser.recognise("clients_20200130.csv");
        Assertions.assertEquals(InputType.CLIENTS, type);
    }

    @Test
    void recognisePortfolios() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        InputType type = typeRecogniser.recognise("portfolios_20200130.csv");
        Assertions.assertEquals(InputType.PORTFOLIOS, type);
    }

    @Test
    void recogniseAccounts() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        InputType type = typeRecogniser.recognise("accounts_20200130.csv");
        Assertions.assertEquals(InputType.ACCOUNTS, type);
    }

    @Test
    void recogniseTransactions() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        InputType type = typeRecogniser.recognise("transactions_20200130.csv");
        Assertions.assertEquals(InputType.TRANSACTIONS, type);
    }

    @Test
    void recogniseUnknown() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        InputType type = typeRecogniser.recognise("AWDASNDAWDNKAD_20200130.csv");
        Assertions.assertEquals(InputType.UNKNOWN, type);
    }

    @Test
    void getClientsTypeFromFilename() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        String type = typeRecogniser.getTypeFromFilename("clients_20200130.csv");
        Assertions.assertEquals("CLIENTS", type);
    }

    @Test
    void getAccountsTypeFromFilename() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        String type = typeRecogniser.getTypeFromFilename("accounts_20200130.csv");
        Assertions.assertEquals("ACCOUNTS", type);
    }

    @Test
    void getTransactionsTypeFromFilename() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        String type = typeRecogniser.getTypeFromFilename("transactions_20200130.csv");
        Assertions.assertEquals("TRANSACTIONS", type);
    }

    @Test
    void getPortfoliosTypeFromFilename() {
        TypeRecogniser typeRecogniser = new TypeRecogniser();
        String type = typeRecogniser.getTypeFromFilename("portfolios_20200130.csv");
        Assertions.assertEquals("PORTFOLIOS", type);
    }

}
